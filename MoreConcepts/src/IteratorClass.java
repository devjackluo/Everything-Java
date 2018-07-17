import java.util.Iterator;
import java.util.LinkedList;

public class IteratorClass<T> implements Iterator<T> {

    private LinkedList<T> arrayOfItems = new LinkedList<T>();
    private int index = 0;

    public IteratorClass(LinkedList<T> things){
        for (T t : things){
            arrayOfItems.add(t);
        }
    }


    @Override
    public boolean hasNext() {
        return index < arrayOfItems.size();
    }

    @Override
    public T next() {
        T t = arrayOfItems.get(index);
        index++;
        return t;
    }

}

