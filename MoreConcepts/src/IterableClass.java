import java.util.Iterator;
import java.util.LinkedList;

public class IterableClass<T> implements Iterable<T> {

    private LinkedList<T> ourThings;

    public IterableClass(LinkedList<T> thingsToAdd){
//        for(T t : thingsToAdd){
//            ourThings.add(t);
//        }
        ourThings = thingsToAdd;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorClass<T>(ourThings);
    }

}
