package Iterator;

import java.util.Iterator;

public class IteratorDemo {

    public static void main(String[] args){

        BikeRepository repo = new BikeRepository();

        repo.addBike("Cervelo");
        repo.addBike("Scott");
        repo.addBike("Fuji");
        repo.addBike("Cervelo");
        repo.addBike("Scott");
        repo.addBike("Fuji");

//        Iterator<String> bikeIterator = repo.iterator();
//        while(bikeIterator.hasNext()){
//            System.out.println(bikeIterator.next());
//        }

        for(String s : repo){
            System.out.println(s);
        }

    }

}
