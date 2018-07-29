package BridgePartTwo;

import BridgePartTwo.Formats.Formatter;
import BridgePartTwo.Formats.PrintFormatter;
import BridgePartTwo.Formats.htmlFormatter;

public class BridgeDemo {

    public static void main(String[] args){

        Movie movie = new Movie();
        movie.setClassification("Action");
        movie.setTitle("John Wick");
        movie.setRuntime("1:49");
        movie.setYear("2014");


        Formatter printFormatter = new PrintFormatter();
        Printer moviePrinter = new MoviePrinter(movie);
        String printedMaterial = moviePrinter.print(printFormatter);
        System.out.println(printedMaterial);


        Formatter htmlFormatter = new htmlFormatter();
        String htmlMaterial = moviePrinter.print(htmlFormatter);
        System.out.println(htmlMaterial);


    }


}
