public class Stuff<T> {

    T item;

    public Stuff(T item){
        this.item = item;
    }

    @Override
    public String toString() {
        return item.toString();
    }
}
