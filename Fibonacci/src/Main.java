public class Main {

    public static void main(String[] args){

        //FibCalculator fibCalculator = new NaiveRecursiveFib();
        //FibCalculator fibCalculator = new IterativeFib();
        FibCalculator fibCalculator = new MemoizedFib();

        System.out.println(fibCalculator.fib(80));
    }

}
