package cscd211LinkedList;

import java.util.*;


public class LinkedList {

   private class Node {
   
      public Comparable item;
      public Node next;
   
      public Node() {
      
         this(null, null);
      
      }
   
      public Node(final Comparable item) {
      
         this(item, null);
      }
   
      public Node(final Comparable item, final Node Next) {
      
         this.item = item;
         this.next = next;
      }
   }//end of Node class

   private Node head;
   private int size;

   public LinkedList() {
   
      this.size = 0;
      this.head = null;
      //NDHN
   
      //this.size = 0;
      // this.head = new Node();
      //DHN
   }

   public void clear() {
   
      this.head = null;
      this.size = 0;
   
      //TODO DHN is different
   }

   public int size() {
   
      return this.size;
   
   }

   public void addFirst(final Comparable item) {

      Node nn = new Node(item);
      if(this.size == 0) {
         this.head = nn;
         this.size++;
      }else {
         nn.next = this.head;
         this.head = nn;
         this.size++;
      }
   
   }

   public void addLast(final Comparable item) {

      if (this.head == null) {
         this.head = new Node(item, null);
         this.size++;
      } else {
         Node nn = new Node(item);
         Node cur = this.head;
         while (cur.next != null) {
            cur = cur.next;
         }
         cur.next = nn;
         this.size++;
      }
   }

   public void add(final int index, final Comparable item) {
   
      if (item == null) {
         throw new IllegalArgumentException("bad addIndex");
      }
         
      
      if (index < 0 || index > this.size) {
         throw new IndexOutOfBoundsException("addIndex Failed");
      }
     
   
      if (index == 0) {
         this.addFirst(item);
      }else if(index == size){
         this.addLast(item);
      }else {
      
         Node nn = new Node(item);
         Node cur = this.head, prev = null;
         for (int x = 0; x < index; x++) {
            prev = cur;
            cur = cur.next;
         }
         nn.next = cur;
         prev.next = nn;
         this.size++;
      }
   
   }

   public Comparable removeFirst(){
   
      if(this.size == 0){
      
         throw new NoSuchElementException("Bad removeFirst");
      
      }
      //Comparable d = this.head.item; // parent ref to a child object
      // this.head = this.head.next;
      // this.size--;
      //
      // return d;
   
      Node cur = this.head;
      this.head = this.head.next;
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
   
      Node cur = this.head, prev = null;
   
      for( ; cur.next != null; cur = cur.next) {
         prev = cur;
      }
   
      if(prev == null) {
         Comparable d = cur.item;
         cur.item = null;
         cur.next = null;
         this.head = null;
         this.size--;
         return d;
      } else {
         prev.next = null;
         Comparable d = cur.item;
         cur.item = null;
         cur.next = null;
         this.size--;
         return d;
      }
   
   }

   public boolean removeFirstOccurrence(final Comparable item){
   
      if(this.head == null){
         throw new NoSuchElementException("Bad removeByValue");
      }
   
      Node cur = this.head, prev = null;


      while(cur != null && !cur.item.equals(item)){
         prev = cur;
         cur = cur.next;
      }


//      for(; cur != null && !cur.item.equals(item); cur = cur.next){
//         prev = cur;
//      }

      if(cur == null) {
         return false;
      } else if(prev == null) {
         this.head = cur.next;
         this.size--;
         cur.item = null;
         cur.next = null;
         return true;
      } else {
         prev.next = cur.next;
         this.size--;
         cur.item = null;
         cur.next = null;
         return true;
      }
   }

   public boolean contains(final Comparable item){
      
      if(item == null){
         throw new IllegalArgumentException("Bad contains");
      }
      
      Node cur = this.head;
      while(cur != null){
        
         cur = cur.next;
      
         if(cur.item.equals(item)){
            return true;
         }
      }
   
      return false;
   }
  
   public int indexOf(final Comparable item){
   
      if(item == null){
         throw new IllegalArgumentException("Bad indexOf");
      }
      
      Node cur = this.head;
      int count = -1;
      
      while(cur != null){
        
         count++;
         
         if(cur.item.equals(item)){
            
            return count;
         }
         
         cur = cur.next;
      }
      return -1;
   }
  
   public Comparable remove(int index){
       
      if (index < 0 || index >= this.size) {
         throw new IndexOutOfBoundsException("remove Failed");
      }
      
      Node cur = this.head, prev = null;
      
      for(int x = 0; x < index; x++) {
         
         prev = cur;
         cur = cur.next;     
      }
      if(prev == null){
      
         this.head = null;
         this.size = 0;
             
      } 
      
      else{                     
         prev.next = cur.next;  
         this.size--;
         
      }
      
      return cur.item;
            
   }

   public boolean removeLastOccurrence(final Comparable item) {
      
      if(item == null) {
         throw new NullPointerException("Bad removeLast");
      }
          
      Node cur = this.head, prev = null;
          
      Node delete = null;
      Node prevdelete = null;
          
      for(int x = 0; x < this.size; x++){
         if(cur.item.equals(item)){
            delete = cur;
            prevdelete = prev;
         }
             
         prev = cur;
         cur = cur.next;
          
              
      }
          
      if(delete == null){
         return false;
            
      }
          
      if(prevdelete == null && delete == this.head) {
          
         this.head = null;
         this.size = 0;
         return true;
      }
          
      else
          
      { prevdelete.next = delete.next;
         this.size--;
         return true;
      }
               
   }


   @Override
   public String toString() {
   
      if (this.size == 0) {
         return ("Empty List");
      } else {
      
         String toString = ("[");
         Node cur = this.head;
      
      
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
