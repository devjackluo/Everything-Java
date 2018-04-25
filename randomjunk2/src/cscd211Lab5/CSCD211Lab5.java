package cscd211Lab5;

import java.util.Scanner;
import cscd211Misc.*;
import cscd211LinkedList.*;
/**
 * The class that contains main and is used for testing our LinkedList code
 */
public class CSCD211Lab5
{
   public static void main(String [] args) throws Exception
   {
      BoxCar aCar = null;
      boolean res =  false;
      BoxCar [] cars = null;
      Comparable item = null;
      Comparable [] array = null;   
      int choice = 0, result = 0, index = 0;
      Scanner kb = new Scanner(System.in);
      
      cars = LinkedListMethods.fillArray(kb, 5);  // 5 cars in the array
      
      LinkedList myList = new LinkedList(cars); // dummy head node
      
      do
      {
         choice = LinkedListMethods.menu(kb);
         
         switch(choice)
         {
            case 1:  System.out.println(myList);
                     break;
                     
            case 2:  aCar = LinkedListMethods.createBoxCar(kb);
                     res = myList.add(aCar);
                     System.out.println("The results of add " + res);
                     break;
            
            case 3:  cars = LinkedListMethods.fillArray(kb, 3);
                     index = LinkedListMethods.readIndex(kb);
                     res = myList.addAll(index, cars);
                     System.out.println("The results of addAll " + res);

                     break;
            
            case 4:  index = LinkedListMethods.readIndex(kb);
                     item = myList.get(index);
                     System.out.println("The results of get " + item);
                     break;

            case 5:  item = myList.getLast();
                     System.out.println("The results of getLast " + item);
                     break;

            case 6:  item = myList.remove();
                     System.out.println("The results of remove " + item);
                     break;

            case 7:  index = LinkedListMethods.readIndex(kb);
                     item = myList.remove(index);
                     System.out.println("The results of remove " + item);
                     break;

            case 8:  item = myList.removeLast();
                     System.out.println("The results of removeLast " + item);
                     break;

            case 9:  array = myList.toArray();
                     for(Comparable c: array)
                        System.out.print(c + " ");
                     System.out.println();
                     break;
                     
            case 10: myList.clear();
                     break;
                     
            case 11: System.out.println("List size: " + myList.size());
                     break;            

            default: System.out.println("Program ending");
         
         }// end switch
      
      }while(choice != 12);
   
   }// end main

}// end class