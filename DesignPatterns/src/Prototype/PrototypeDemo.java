package Prototype;

public class PrototypeDemo {

    public static void main(String[] args){

        Registry resgistry = new Registry();


        Movie movie = (Movie) resgistry.createItem("Movie");
        movie.setTitle("Spider-man 3");
        System.out.println(movie);

        Movie movie2 = (Movie) resgistry.createItem("Good Movie");
        movie.setTitle("Spider-man 2");
        System.out.println(movie2);

        Movie movie3 = (Movie) resgistry.createItem("Good Movie");
        movie.setTitle("The Lobster");
        System.out.println(movie3);


        Book book = (Book) resgistry.createItem("Book");
        book.setTitle("Game of Thrones");
        System.out.println(book);

        Book book2 = (Book) resgistry.createItem("Good Book");
        book.setTitle("Hatchet");
        System.out.println(book2);

        Book book3 = (Book) resgistry.createItem("Good Book");
        book.setTitle("Giverrrrr");
        System.out.println(book3);

    }

}
