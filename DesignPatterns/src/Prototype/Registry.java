package Prototype;

import java.util.HashMap;
import java.util.Map;

public class Registry {

    private Map<String, Item> items = new HashMap<String, Item>();

    public Registry(){
        loadItems();
    }

    public Item createItem(String type){
        Item item = null;
        try{
            item = (Item)(items.get(type).clone());
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return item;
    }


    private void loadItems(){
        Movie movie = new Movie();
        movie.setTitle("Basic Movie");
        movie.setPrice(24.99);
        movie.setRuntime("2 hours");
        items.put("Movie", movie);

        Movie movie2 = new Movie();
        movie.setTitle("Good Movie");
        movie.setPrice(44.99);
        movie.setRuntime("3 hours");
        items.put("Good Movie", movie2);


        Book book = new Book();
        book.setPages(234);
        book.setPrice(14.56);
        book.setTitle("Basic Book");
        items.put("Book", book);

        Book book2 = new Book();
        book.setPages(334);
        book.setPrice(34.99);
        book.setTitle("Good Book");
        items.put("Good Book", book2);

    }

}
