package cscd211Methods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Lab3Methods {

    public static void addNum(ArrayList<Double> myAlist, Scanner kb) {

        if (kb == null || myAlist == null) {
            throw new IllegalArgumentException("Bad addNum");
        }

        System.out.println("Please enter a number between 0 and 100");
        //get a double from user
        double num = kb.nextDouble();

        //if it is between 0-100 ass it.
        if (num < 0 || num > 100) {
            System.out.println("Please try again with a number between 0 and 100");
        } else {
            myAlist.add(num);
        }

        //System.out.print("asfas");
    }

    public static double computeMean(ArrayList<Double> myAlist) {

        if (myAlist.size() == 0 || myAlist == null)
            throw new IllegalArgumentException("Bad computeMean");

        double total = 0;

        for (int i = 0; i < myAlist.size(); i++) {

            total += myAlist.get(i);
        }

        //seems good.
        return total / myAlist.size();


    }

    public static double computeMedian(ArrayList<Double> myAlist) {

        if (myAlist.size() == 0 || myAlist == null)
            throw new IllegalArgumentException("Bad computeMedian");

        Collections.sort(myAlist);

        double total;
        int num = 0;
        int i = 0;

        //interesting. seems good
        if (myAlist.size() % 2 == 1) {

            i = myAlist.size() / 2;
            return myAlist.get(i);

        } else {


            i = myAlist.size() / 2;
            num = i - 1;
            total = (myAlist.get(i) + myAlist.get(num)) / 2.0;
            return total;
        }

    }

    public static double computeMidpoint(ArrayList<Double> myAlist) {

        if (myAlist.size() == 0 || myAlist == null)
            throw new IllegalArgumentException("Bad computeMidpoint");

        Collections.sort(myAlist);

        double num = (myAlist.get(0) + myAlist.get(myAlist.size() - 1)) / 2.0;

        //seems good.
        return num;
    }

    public static double computeStandardDeviation(ArrayList<Double> myAlist) {

        if (myAlist.size() == 0 || myAlist == null)
            throw new IllegalArgumentException("Bad computeStandardDeviation");

        //get the mean...
        double mean = computeMean(myAlist);
        //make a empty array again.
        ArrayList<Double> deviation = new ArrayList<Double>(myAlist.size());
        //variables.
        double total = 0;
        double standard, standardRoot;

        //k, not even going to bother. i believe you.
        for (int i = 0; i < myAlist.size(); i++)
            deviation.add(i, Math.pow(myAlist.get(i) - mean, 2));

        for (int i = 0; i < deviation.size(); i++)
            total += deviation.get(i);

        standard = total / (myAlist.size() - 1);
        standardRoot = Math.sqrt(standard);

        return standardRoot;
    }

    public static void deleteValue(ArrayList<Double> myAlist, Scanner kb) { //TODO If value does not exist it doesnt get printed to screen!!

        if (kb == null || myAlist == null || myAlist.size() < 1) {
            throw new IllegalArgumentException("Bad deleteValue");
        }

        System.out.println("Enter value between 0 and 100 to remove");

        //get double from user
        double num = kb.nextDouble();

        //if (num > 0 && num < 100) {
        //    myAlist.remove(num);
        //    myAlist.trimToSize();
        //    System.out.println(num);
        //}

        //if it is removing, you don't need to check if it is valid
        //you only have to check that it was able to remove that value.
        if (myAlist.remove(num)) {
            myAlist.trimToSize();
            System.out.println(num);
        }


    }

    public static void deleteValueByIndex(ArrayList<Double> myAlist, Scanner kb) {
        if (kb == null || myAlist == null || myAlist.size() < 1) {
            throw new IllegalArgumentException("Bad deleteValueByIndex");
        }

        System.out.println("Please enter index value to remove from array list");

        int index = kb.nextInt();
        kb.nextLine();

        //funny how this is same as delete value just that one is calling remove(Oject o) and this calling remove(int index)
        //myAlist.remove((double)index);

        if(index >=0 && index < myAlist.size()) {
            myAlist.remove(index);
            myAlist.trimToSize();
        }else{
            System.out.println("Out of bounds.");
            //throw new IndexOutOfBoundsException("index out of range");
        }

        // if( index < 0 || index > (myAlist.size()-1));
        //   {
        //      throw new IndexOutOfBoundsException("index out of range");
        // }


    }

    public static void fillArrayList(int size, ArrayList<Double> myAlist) {


        //for size of
        for (int x = 0; x < size; x++) {

            //generate a random number * 101? ok
            double num = Math.random() * (100 - 1 + 1) + 1;

            //we want it 0-100
            if (num > 100)
                num = 100;

            //we just add that rn to our list
            myAlist.add(num);
        }

        //check list at end
        if (myAlist == null || myAlist.size() < 1)
            throw new IllegalArgumentException("Bad fill Array");


    }


    public static int menu(Scanner kb) {

        //check scanner
        if (kb == null) {
            throw new IllegalArgumentException("Bad Menu");
        }

        //print bunch of stuff
        System.out.println("1) Add a value to the ArrayList");
        System.out.println("2) Delete a value from the ArrayList (by value)");
        System.out.println("3) Delete a value from the ArrayList (by index/location)");
        System.out.println("4) Display the ArrayList ");
        System.out.println("5) Compute the mean of the ArrayList");
        System.out.println("6) Compute the median of the ArrayList");
        System.out.println("7) Compute the midpoint of the ArrayList");
        System.out.println("8) Compute the standard deviation of the ArrayList");
        System.out.println("9) Quit");

        //get int from kb
        int choice = kb.nextInt();

        // is this how nextLine works? doesn't seem needed..?
        //kb.nextLine();

        //k
        if (choice < 1 || choice > 9) {
            System.out.println("Please enter value from 1 to 9");
        }

        //return their choice.
        return choice;

    }

    public static void printArrayList(ArrayList<Double> myAlist) {

        if (myAlist == null) {
            throw new IllegalArgumentException("Bad printArraylist");
        }
        myAlist.trimToSize();
        System.out.println(myAlist);

    }

    public static void printResults(String type, double value) {

        //make a function just to do a system.out. k...
        if (type == null || type.equals("")) {
            throw new IllegalArgumentException("Bad printResults");
        }

        System.out.println(type + " " + value);
    }

    public static int readNum(Scanner kb) {

        //check scanner.
        if (kb == null) {
            throw new IllegalArgumentException("Bad readNum");
        }

        //get a number from user.
        System.out.println("Enter a positive number that is at least 1");
        int readNum = kb.nextInt();
        //kb.nextLine();

        //if greater than 1 return it.
        if (readNum >= 1)
            return readNum;

        // if not return 0.
        return 10;
    }


}
