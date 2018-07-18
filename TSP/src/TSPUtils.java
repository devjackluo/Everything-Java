import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class TSPUtils {

    private final static Random R = new Random(10000);

    //INITIAL AMOUNT OF CITIES
    public static final TSPGene[] CITIES = generateData(20);

    private TSPUtils(){
        throw new RuntimeException("Can't make this class!");
    }

    //GENERATES A ARRAY OF GENES OF NUMDATAPOINT SIZE
    //GENES GET A RANDOM X AND Y DEPENDING ON SCREEN SIZE
    public static TSPGene[] generateData(final int numDataPoints) {
        final TSPGene[] data = new TSPGene[numDataPoints];
        for(int i = 0; i < numDataPoints; i++){
            data[i] = new TSPGene(TSPUtils.randomIndex(World.WIDTH), TSPUtils.randomIndex(World.HEIGHT));
        }
        return data;
    }

    public static int randomIndex(final int limit){
        return R.nextInt(limit);
    }

    public static<T> List<T>[] split(final List<T> list){

        //SPLIT UTILS TAKES A LIST OF GENERIC(CHROMOSOMES)
        //ALTERNATING EACH GENE AND ADDING TO FIRST OR SECOND
        final List<T> first = new ArrayList<>();
        final List<T> second = new ArrayList<>();
        final int size = list.size();
        IntStream.range(0, size).forEach(i ->{
//            if(i < (size+1)/2){
//                first.add(list.get(i));
//            }else{
//                second.add(list.get(i));
//            }

            if(i % 2 == 0){
                first.add(list.get(i));
            }else{
                second.add(list.get(i));
            }
        });
        //RETURNING LIST OF ARRAYS COMBINING FIRST AND SECOND
        return (List<T>[]) new List[]{first, second};
    }

}
