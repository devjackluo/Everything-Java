public class IterativeFib implements FibCalculator {

    @Override
    public long fib(final long n) {
        if(n <= 1){
            return n;
        }
        long fib = 1;
        long prevFib = 1;

        for(int i=2; i<n; i++){
            long temp = fib;
            fib += prevFib;
            prevFib = temp;
        }
        return fib;

    }

}
