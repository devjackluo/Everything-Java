
public class NaiveRecursiveFib implements FibCalculator {



    @Override
    public long fib(final long n) {

        Main.count++;

        //if recursive n reached 0
        if(n <= 1){
            return n;
        }

        //otherwise fib(79) + fib (78) .. etc
        //which called fib(78) + fib(77) and fib(77) + fib(76)

        //this keeps going all the way until it reaches 1 and returns 1 for fib(1)
        //then it starts it return journey all the way back to fib(80)


        return fib(n-1) + fib(n-2 );
    }

}
