public class IterativeFib implements FibCalculator {

    @Override
    public long fib(final long n) {

        Main.count++;

        //if number if fib is less than 1, obv return 0
        if(n <= 1){
            return n;
        }

        //start fib at 1 and prevfib at 1
        long fib = 1;
        long prevFib = 1;

        //because starting at 1 means fib loop starts at 2
        for(int i=2; i<n; i++){

            Main.count++;

            //store old fibnum
            long temp = fib;
            //fib add old fib
            fib += prevFib;
            //old fib is previous fib
            prevFib = temp;
        }

        //fib = 2
        //pf = 1

        //fib = 3
        //pf = 2

        //fib = 5
        //pf = 3

        //etc until num of times doing these reach n times.

        return fib;

    }

}
