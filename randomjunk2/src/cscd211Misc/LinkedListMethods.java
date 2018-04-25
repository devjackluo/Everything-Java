package cscd211Misc;

import java.util.*;

public class LinkedListMethods {

   public static int menu(final Scanner kb) {
   
      System.out.println("1) Print the List");
      System.out.println("2) Create a BoxCar and append the specified element to the end of this list.");
      System.out.println("3) addAll(index, array)");
      System.out.println("4) Read an index and get the data at that index");
      System.out.println("5) getLast");
      System.out.println("6) remove");
      System.out.println("7) removeIndex");
      System.out.println("8) removeLast");
      System.out.println("9) toArray");
      System.out.println("10) clear the list");
      System.out.println("11) Print the size of the list");
      
      int choice;
           
      do{
      
         System.out.println("Enter your choice");
         
         choice = Integer.parseInt(kb.nextLine());
         

      }while(choice < 1 || choice > 11);
      
      return choice;
      
   
   }
   
   public static BoxCar createBoxCar(final Scanner kb){
   
      if(kb == null) {
         throw new NullPointerException("Bad createBoxCar");
      }
      
      
      BoxCar nc = new BoxCar(kb.nextLine());
      
      return nc;
      
   }
   
   public static int readIndex(final Scanner kb){
      
      if(kb == null) {
         throw new NullPointerException("Bad readIndex");
      }
         int index;
         
         do{
            System.out.print("Enter a Index value ");
            index = Integer.parseInt(kb.nextLine());
            
         } while(index <= -1);
      
      return index;
   
   }
   
   public static BoxCar[] fillArray(final Scanner kb, int total){
   
      if(kb == null) {
         throw new NullPointerException("Bad kb in fillArray");
      }

      if(total < 1) {
         throw new IllegalArgumentException("Bad total in fillArray");
      }
      
      BoxCar[] newArray = new BoxCar[total];
      int x = 0;
      while(x < total){

         //newArray[x]= new BoxCar(kb.nextLine());
         newArray[x]= new BoxCar(Integer.toString(x)+" lol");
         x++; 
      }
      
      return newArray;
      
      
      
      
   }
   
}