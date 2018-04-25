package cscd211Misc;


/**
 * Basic BoxCar class for use in the linked list world
 */
public class BoxCar implements Comparable<BoxCar>
{
   private String contents;
   
   /**
    * EVC takes a String because a BoxCar only contains a String
    *
    * @param contents The String in the BoxCar
    *
    * @throws NullPointerException if the contents are null
    * @throws IllegalArgumentException if the contents are empty
    */
   public BoxCar(final String contents)
   {
      this.contents = contents;
   }
   
   /**
    * toString returns the contents of the BoxCar
    *
    * @return String the BoxCar contents
    */
   public String toString()
   {
      return this.contents;
   }
   
   /**
    * compareTo BoxCar contents
    *
    * @param pi The BoxCar passed in
    * @return int Representing order
    * 
    @throws NullPointerException if the passed in object is null
    */
   public int compareTo(final BoxCar pi)
   {
      return this.contents.compareTo(pi.contents);
   }
   
   /**
    * equals checks to see if the BoxCar contents are equal to the
    * BoxCar passed in
    *
    * @param obj The Object being checked 
    * @return boolean true if the contents match false otherwise
    */
   public boolean equals(Object obj)
   {
      BoxCar pi = (BoxCar)obj;
      return this.contents.equals(pi.contents);
   }
   
   /**
    * hashCode returns the hashCode from String for the contents
    *
    * @return int The hashCode for contents from String
    */
   public int hashCode()
   {
      return this.contents.hashCode();
   }
}// end Boxcar