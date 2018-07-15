
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class volatileTest {

    static volatile int count = 0;

    //static List<String> pets = new ArrayList<String>();

    public static void main(String[] argv) {



//        pets.add("dog");
//        pets.add("dog");
//        pets.add("dog");
//        pets.add("dog");
//        pets.stream().parallel().forEach((p) -> count++);

        //if parallel threads access count at the same time,
        //they would both ++ count to the same number resulting in a missing increment
        IntStream.range(0, 1000)
                .parallel()
                .forEach(e -> count++);

        System.out.println(1/2);

        System.out.println(count);

    }

}
