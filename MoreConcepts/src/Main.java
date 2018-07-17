import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args){

        LinkedList<Integer> llist = new LinkedList<>();
        llist.add(1);
        llist.add(5);

        System.out.println("INSTANCE OF LINKED LIST ITERATOR");
        //You can only iterate only once...
        Iterator it = llist.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("TRYING TO RUN LINKED LIST ITERATOR AGAIN.. RESULTS NOTHING");
        while(it.hasNext()){
            System.out.println(it.next());
        }



        System.out.println("INSTANCE OF ITERABLE CLASS");
        //ITERABLE  (uses a iterator)
        //iterable lets us use the powerful for statement
        IterableClass ic = new IterableClass(llist);
        for(Object s : ic){
            System.out.println(s);
        }
        System.out.println("SINCE ITERABLE USES ITERABLE, WHEN YOU USE IT FOR LOOP, IT CREATES A FRESH ITERATOR");
        for(Object s : ic){
            System.out.println(s);
        }
        System.out.println("LIKE SO");
        for(Object s : ic){
            System.out.println(s);
        }
        System.out.println("AND AGAIN TO MAKE A POINT");
        for(Object s : ic){
            System.out.println(s);
        }



        System.out.println("INSTANCE OF ITERATOR CLASS");
        //JUST ITERATOR
        IteratorClass icc = new IteratorClass<>(llist);
        while(icc.hasNext()){
            System.out.println(icc.next());
        }


        System.out.println("INSTANCE OF ITERABLE'S ITERATOR");
        Iterator icit = ic.iterator();
        while(icit.hasNext()){
            System.out.println(icit.next());
        }
        System.out.println("TRYING TO RUN ITERABLE'S ITERATOR AGAIN.. ALSO RESULTS NOTHING");
        Iterator icit2 = ic.iterator();
        while(icit.hasNext()){
            System.out.println(icit.next());
        }


    }

}
