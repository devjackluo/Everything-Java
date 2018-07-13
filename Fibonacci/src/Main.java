public class Main {

    static long count = 0;

    public static void main(String[] args){

        //FibCalculator fibCalculator = new NaiveRecursiveFib();
        //FibCalculator fibCalculator = new IterativeFib();
        FibCalculator fibCalculator = new MemoizedFib();



        System.out.println( "Answer: " + fibCalculator.fib(40));

        if(fibCalculator.getClass() == NaiveRecursiveFib.class){

            System.out.println("Naive Fib took : " + Main.count + " calculations of fib");

        }else if(fibCalculator.getClass() == MemoizedFib.class){

            System.out.println("Took : " + Main.count + " calculations of fib");
            count = 0;
            System.out.println("Reuse memorized fib.");
            System.out.println( "Answer: " + fibCalculator.fib(40));
            System.out.println("Took : " + Main.count + " calculations of fib");

        }else{

            System.out.println("Took : " + Main.count + " calculations of fib");

        }



    }

}
