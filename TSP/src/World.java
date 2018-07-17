import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

public class World extends JPanel{

    //private final TSPPopulation population;
    private final TSPPopulationThread population;
    private final AtomicInteger generation;
    //private volatile AtomicInteger generation;

    static  final int WIDTH = 800;
    static final int HEIGHT = 600;

    private World(){
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);

        //CREATE A POPULATION
        //PASSING AN ARRAY OF GENES WITH RANDOM POINTS AND A SIZE
        //this.population = new TSPPopulation(TSPUtils.CITIES, 1000);
        this.population = new TSPPopulationThread(TSPUtils.CITIES, 1000);

        this.generation = new AtomicInteger(0);

        //LOOP UPDATE EVERY X MILLISECONDS AND REPAINT
        final Timer timer = new Timer(5, e ->{
            this.population.update();
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        final Graphics2D graphics = (Graphics2D) g;
        graphics.setColor(Color.CYAN);
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.drawString("gen : " + this.generation.incrementAndGet(), 350, 15);

        graphics.drawString("shortest path : " + String.format("%.2f", this.population.getAlpha().calculateDistance()), 500, 15);
        drawBestChromosome(graphics);
    }


    private void drawBestChromosome(Graphics g) {
        final java.util.List<TSPGene> chromosome = this.population.getAlpha().getChromosome();
        g.setColor(Color.WHITE);

        for(int i = 0; i < chromosome.size() - 1; i++){
            TSPGene gene = chromosome.get(i);
            TSPGene neighbor = chromosome.get(i + 1);
            g.drawLine(gene.getX(), gene.getY(), neighbor.getX(), neighbor.getY());
        }

        TSPGene start = chromosome.get(0);
        TSPGene end = chromosome.get(chromosome.size()-1);
        g.drawLine(start.getX(), start.getY(), end.getX(), end.getY());

        g.setColor(Color.RED);
        for(final TSPGene gene: chromosome){
            g.fillOval(gene.getX(), gene.getY(), 5, 5);
        }
    }


    public static void main(String[] args){

        SwingUtilities.invokeLater(() ->{
            final JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setTitle("Genetic Algorithms");
            frame.setResizable(false);
            frame.add(new World(), BorderLayout.CENTER);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

    }

}
