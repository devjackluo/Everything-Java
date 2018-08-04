package Iterator;

import java.util.Iterator;

public class BikeRepository implements Iterable<String> {

    private String[] bikes;
    private int index;

    public BikeRepository(){
        bikes = new String[5];
        index = 0;
    }

    public void addBike(String item){
        if(index == bikes.length){
            String[] larger = new String[bikes.length * 2];
            System.arraycopy(bikes, 0, larger, 0, bikes.length);
            bikes = larger;
            //larger = null;
        }
        bikes[index] = item;
        index++;
    }


    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < index && bikes[currentIndex] != null;
            }

            @Override
            public String next() {
                return bikes[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Nope");
            }
        };

    }
}
