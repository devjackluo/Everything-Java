import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TSPChromosome {

    private final List<TSPGene> chromosome;


    public TSPChromosome(final List<TSPGene> chromosome){
        this.chromosome = Collections.unmodifiableList(chromosome);
    }


    public static TSPChromosome create(final TSPGene[] points){
        //CREATE TAKES ALL GENE POINTS AND SHUFFLES THEN RETURNING A NEW CHROMOSOME USING CONSTRUCTOR
        final List<TSPGene> genes = Arrays.asList(Arrays.copyOf(points, points.length));
        Collections.shuffle(genes);
        return new TSPChromosome(genes);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
//        for(final TSPGene gene : this.chromosome){
//            builder.append(gene.toString()).append((" : "));
//        }
        builder.append(calculateDistance());

        return builder.toString();
    }

    public List<TSPGene> getChromosome() {
        return chromosome;
    }

    public double calculateDistance(){
        double total = 0.0;
        for(int i = 0; i < this.chromosome.size()-1; i++){
            //System.out.println(this.chromosome.get(0).distance(this.chromosome.get(1)));
            total += this.chromosome.get(i).distance(this.chromosome.get(i+1));
        }
        //System.out.println(total);
        return total;
    }


    public TSPChromosome[] crossOver(final TSPChromosome other){

        //SPLIT SELF AND PARTNER
        final List<TSPGene>[] myDNA = TSPUtils.split(this.chromosome);
        final List<TSPGene>[] otherDNA = TSPUtils.split(other.chromosome);

        //NEW HOLDER WITH HALF OF SPLITTED GENES
        final List<TSPGene> firstCrossOver = new ArrayList<>(myDNA[0]);

        //FOR ALL GENES IN FIRST SPLIT OF PARTNER
        //ADD IF IT DOES HAVE IT
        for(TSPGene gene : otherDNA[0]){
            if(!firstCrossOver.contains(gene)){
                firstCrossOver.add(gene);
            }
        }

        //FOR SECOND HALF OF PARTNER, ALSO ADD IF IT DOESNT HAVE
        //WILL ALWAYS END IN SAME AMOUNT AS FULL GENE BECAUSE YOU BEGIN HALF EACH PARTNER HALF COULD CONTAIN HALF TO NONE
        for(TSPGene gene : otherDNA[1]){
            if(!firstCrossOver.contains(gene)){
                firstCrossOver.add(gene);
            }
        }

        //DO THE SAME FOR PARTNER TO GENERATE GIVE HIM HIS HALF
        final List<TSPGene> secondCrossOver = new ArrayList<>(otherDNA[1]);

        for(TSPGene gene : myDNA[0]){
            if(!secondCrossOver.contains(gene)){
                secondCrossOver.add(gene);
            }
        }

        for(TSPGene gene : myDNA[1]){
            if(!secondCrossOver.contains(gene)){
                secondCrossOver.add(gene);
            }
        }

        if(firstCrossOver.size() != TSPUtils.CITIES.length || secondCrossOver.size() != TSPUtils.CITIES.length){
            throw new RuntimeException("invalid crossover");
        }

        //RETURN AN ARRAY OF CHROMOSOMES OF NEW GENES SWAPPED AROUND
        return new TSPChromosome[]{
                new TSPChromosome(firstCrossOver),
                new TSPChromosome(secondCrossOver)
        };
    }

    public TSPChromosome mutate(){

        //COPY CHROMOSOME
        //GET RANDOM INDEX FOR SWAP
        //IF THEY DON'T MATCH SWAP IT
        final List<TSPGene> copy = new ArrayList<>(this.chromosome);
        int indexA = TSPUtils.randomIndex(copy.size());
        int indexB = TSPUtils.randomIndex(copy.size());
        while(indexA == indexB){
            indexA = TSPUtils.randomIndex(copy.size());
            indexB = TSPUtils.randomIndex(copy.size());
        }

        Collections.swap(copy, indexA, indexB);


        if(TSPUtils.randomIndex(10) > 5){

            indexA = TSPUtils.randomIndex(copy.size());
            indexB = TSPUtils.randomIndex(copy.size());
            while(indexA == indexB){
                indexA = TSPUtils.randomIndex(copy.size());
                indexB = TSPUtils.randomIndex(copy.size());
            }
            Collections.swap(copy, indexA, indexB);


            if(TSPUtils.randomIndex(10) > 5){

                indexA = TSPUtils.randomIndex(copy.size());
                indexB = TSPUtils.randomIndex(copy.size());
                while(indexA == indexB){
                    indexA = TSPUtils.randomIndex(copy.size());
                    indexB = TSPUtils.randomIndex(copy.size());
                }
                Collections.swap(copy, indexA, indexB);


                if(TSPUtils.randomIndex(10) > 5){

                    indexA = TSPUtils.randomIndex(copy.size());
                    indexB = TSPUtils.randomIndex(copy.size());
                    while(indexA == indexB){
                        indexA = TSPUtils.randomIndex(copy.size());
                        indexB = TSPUtils.randomIndex(copy.size());
                    }
                    Collections.swap(copy, indexA, indexB);
                }

            }

        }

        //RETURN CHROMOSOME WITH JUST A SINGLE TWO GENE SWAP
        return new TSPChromosome(copy);
    }

}
