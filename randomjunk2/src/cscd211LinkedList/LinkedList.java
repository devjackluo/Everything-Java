package cscd211LinkedList;

import cscd211Misc.BoxCar;

import java.util.*;


public class LinkedList {

   private class Node {
   
      public Comparable item;
      public Node next;
   
      public Node() {
      
         this(null, null);
      
      }
   
      public Node(final Comparable item) {
      
         this(item , null);
      }
   
      public Node(final Comparable item, final Node Next) {
         this.item = item;
         this.next = next;
      }

   }//end of Node class

   private Node head;
   private int size;

   public LinkedList(final Comparable[] array) {
   
     // this.size = 0;
     // this.head = null;
      //NDHN
   
      this.size = 0;
      this.head = new Node();
      //DHN



      addAll(0, array);
      //addAll(3, array);



   }

   public void clear() {
   
     // this.head = null;
     // this.size = 0;
      this.head = new Node();
      this.size = 0;
   
      
   }

   public int size() {
   
      return this.size;
   
   }

   public void addFirst(final Comparable item) {
   
      if(item == null){
         throw new NullPointerException("bad addFirst");
      }
      
      this.head.next = new Node(item,this.head.next);
      this.size++;
     
   }
     
     
   public boolean add(final Comparable item) {

      Node nn = new Node(item,this.head);
      Node cur = this.head;
      while(cur.next != null) {
         cur = cur.next;
      }
      cur.next = nn;
      this.size++;
      return true;

   
   
   }// end of addLast Method


   public Comparable remove(){
   
      if(this.head.next == null){
      
         throw new NoSuchElementException("Empty List");
      
      }
        
      Node cur = this.head.next;
      this.head = cur.next;
      this.size--;
      Comparable d = cur.item;
      cur.item = null;
      cur.next = null;
      return d;
   
   }

   public Comparable removeLast()
   {
      if(this.size == 0){
         throw new NoSuchElementException("Bad removeLast");
      }
   
      Node cur = this.head.next;
      Node prev = this.head;
   
      for( ; cur.next != null; cur = cur.next) {
      
         prev = cur;
      
      } //cur.next == null, last node of the list
     
      prev.next = cur.next;
      Comparable d = cur.item;
      cur.item = null;
      cur.next = null;
      this.size--;




      return d;
            
      
   }
       
   public Comparable remove(final int index){
   
      if(index < 0 || index >= this.size){
         throw new IndexOutOfBoundsException("Bad get method");
      }
      
      Node cur = this.head.next, prev = this.head;
      
      for(int x = 0; x < index; x++){
         
         prev = cur;   
         cur = cur.next;
         
      }
         
      prev.next = cur.next;
      Comparable d = cur.item;
      cur.item = null;
      cur.next = null;
      this.size--;
      return d;
    
   }
   
   public boolean addAll(final int index, Comparable[] array){

      if(array == null){
         throw new NullPointerException("Bad addAll");
      }

      if(index < 0 || index > this.size){
         throw new IndexOutOfBoundsException("Bad get method");
      }

      int x = 0;
      Node current = head.next;
      Node prev = head;
      while(x < index) {
         prev = current;
         current = current.next;
         x += 1;
      }

      for(Comparable c : array){


//         Node cur = this.head.next;
//         while(cur.next != null) {
//            cur = cur.next;
//         }

         prev.next = new Node(c);
         prev = prev.next;
         this.size +=1;

      }

      prev.next = current;


      return true;

   }
   
   public Comparable get(final int index){
      
      if(index < 0 || index >= this.size){
         throw new IndexOutOfBoundsException("Bad get method");
      }
      
      Node cur = this.head.next;
      
      for(int x = 0; x < index; x++){
        
         cur = cur.next;
         
      }
      
      
      return cur.item;
   }//end get
   
   public Comparable getLast(){
   
      if(this.head.next == null){
         throw new NoSuchElementException("Empty List");
      }
   
      Node cur = this.head.next;
      
      while(cur.next != null) {
         cur = cur.next;
      }
      
      return cur.item;
   
   }
   
   public Comparable[] toArray(){


//      int x = 0;
//      Node current = head.next;
//      while(x < size) {
//         current = current.next;
//         x += 0;
//      }
//
//      int count = 0;
//      Node cur = this.head.next;
//      while(cur.next != null) {
//         cur = cur.next;
//         count++;
//      }


      BoxCar[] array = new BoxCar[size];


      int count = 0;
      Node cur = this.head.next;
      while(count < this.size) {
         array[count] = new BoxCar(cur.item + "");

         cur = cur.next;
         count++;
      }


//      int count2 = 0;
//      Node cur2 = this.head.next;
//      while(cur2 != null) {
//         array[count2] = new BoxCar(cur2.item + "");
//         cur2 = cur2.next;
//         count2++;
//      }

   
      return array;
      
   }
     
      
   
   @Override
   public String toString() {
   
      if (this.size == 0) {
         return ("Empty List");
      } 
      else {
      
         String toString = ("[");
         Node cur = this.head.next;
      
      
         while (cur != null) {
           
            if(cur.next != null){
            
               toString += cur.item + ", ";
               cur = cur.next;
            }
            else
            {
            
               toString += cur.item + "]";
               cur = cur.next;
            
            }
         }
      
         return toString;
      }
   
   
   }

}
