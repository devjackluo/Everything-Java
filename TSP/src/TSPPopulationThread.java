import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TSPPopulationThread {

    private List<TSPChromosome> population;
    private final int initialSize;


    public TSPPopulationThread(final TSPGene[] points, final int initialSize) {
        //INIT USING ARRAY OF GENES AND SIZE
        this.population = init(points, initialSize);
        this.initialSize = initialSize;
    }

    public TSPChromosome getAlpha() {
        return this.population.get(0);
    }

    private List<TSPChromosome> init(final TSPGene[] points, final int initialSize) {

        ExecutorService es = Executors.newFixedThreadPool(100);

        //CREATE A LIST OF CHROMOSOMES OF INITIALSIZE
        final List<TSPChromosome> eden = new ArrayList<>();

        for (int i = 0; i < initialSize; i++) {
            //EACH CHROMOSOME GETS SAME INIT GENES
            //THEN IT GETS SHUFFLED

            es.execute(() -> {

                final TSPChromosome chromosome = TSPChromosome.create(points);

                synchronized (eden) {
                    eden.add(chromosome);
                }

            });

        }

        try {
            es.shutdown();
            es.awaitTermination(100000, TimeUnit.MINUTES);
        } catch (Exception e) {
            System.out.println(e);
        }

        return eden;
    }

    //UPDATE CALLS ALL FUNCTIONS
    public void update() {

        //SWAPS GENES WITH RANDOM PARTNERS TO CREATE NEW CHROMOSOMES, ADD THOSE TO POPULATION
        doCrossOver();
        //GENERATION MUTATED CHROMOSOMES INTO THE POPULATION
        doMutation();
        //ADD RANDOM X AMOUNT OF NEW CHROMOSOMES INTO THE POPULATION
        doSpawn();

        //SORT THE POPULATION BY BEST DISTANCES
        //LIMIT OR KILL OFF THE POPULATION BACK TO INITIAL SIZE
        doSelection();


        //Mutation at end?
        //doMutation();

    }

    private void doSelection() {
        this.population.sort(Comparator.comparingDouble(TSPChromosome::calculateDistance));
        this.population = this.population.stream().limit(this.initialSize).collect(Collectors.toList());
    }

    private void doSpawn() {
        //ADD 1000 RANDOM CHROMOSOMES TO POPULATION
        ExecutorService es = Executors.newFixedThreadPool(100);

        IntStream.range(0, 1000).forEach(e -> es.execute(() -> {

                    synchronized (this.population) {
                        this.population.add(TSPChromosome.create(TSPUtils.CITIES));
                    }

                }
        ));

        try {
            es.shutdown();
            es.awaitTermination(100000, TimeUnit.MINUTES);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void doMutation() {

        ExecutorService es = Executors.newFixedThreadPool(100);

        final List<TSPChromosome> newPopluation = new ArrayList<>();
        // FOR TENTH OF POPULATION
        for (int i = 0; i < this.population.size(); i++) {

            es.execute(() -> {

                //GET RANDOM CHROMOSOME FROM POPULATION
                //MUTATE IT BY RETURN A CHROMOSOME SAME BUT WITH TWO GENES SWAPPED
                TSPChromosome mutation = this.population.get(TSPUtils.randomIndex(this.population.size())).mutate();
                //ADD MUTATED CHROMOSOME TO NEWPOP

                synchronized (newPopluation) {
                    newPopluation.add(mutation);
                }

            });

        }

        try {
            es.shutdown();
            es.awaitTermination(100000, TimeUnit.MINUTES);
        } catch (Exception e) {
            System.out.println(e);
        }

        //ADD A TENTH OF MUTATED CHROMOSOMES TO POPULATION
        this.population.addAll(newPopluation);

    }

    private void doCrossOver() {

        ExecutorService es = Executors.newFixedThreadPool(100);

        //CROSSOVER CREATES NEW LST OF CHROMOSOMES
        final List<TSPChromosome> newPopluation = new ArrayList<>();
        //FOR ALL ESTABLISHED CHROMOSOMES
        for (final TSPChromosome chromosome : this.population) {

            es.execute(() -> {

                //GET RANDOM PARTNER CHROMOSOME FROM POPULATION
                final TSPChromosome partner = getCrossOverPartner(chromosome);

                //FOR EACH EXISTING CHROMOSOME, CROSSOVER WITH PARTNER AND GENERATE ARRAY OF CHROMOSOMES
                //CONVERT ARRAY OF CHROMOSOME TO LIST OF CHROMOSOMES
                //ADD TO ARRAY OF CHROMOSOMES TO NEWPOP LIST

                synchronized (newPopluation) {
                    newPopluation.addAll(Arrays.asList(chromosome.crossOver(partner)));
                }

            });

        }

        try {
            es.shutdown();
            es.awaitTermination(100000, TimeUnit.MINUTES);
        } catch (Exception e) {
            System.out.println(e);
        }

        //ADD COLLECTION FROM NEWPOP TO THE CURRENT POPULATION
        this.population.addAll(newPopluation);

    }

    private TSPChromosome getCrossOverPartner(final TSPChromosome chromosome) {

        //GET RANDOM CHROMOSOME IN POPLUATION
        TSPChromosome partner = this.population.get(TSPUtils.randomIndex(this.population.size()));
        while (chromosome == partner) {
            partner = this.population.get(TSPUtils.randomIndex(this.population.size()));
        }

        //RETURN IF IT IS NOT SAME AS PARTNER
        return partner;
    }

}
