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
        //return new IteratorClass<T>(ourThings);

        //anonymous interface/class
        return new Iterator<T>() {

            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < ourThings.size();
            }

            @Override
            public T next() {
                T t = ourThings.get(index);
                index++;
                return t;
            }

        };


    }

}
