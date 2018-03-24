import java.util.HashMap;
import java.util.Map;

public class MemoizedFib implements FibCalculator{

    private static final Map<Long, Long> cache = new HashMap<>();

    @Override
    public long fib(long n) {

        if(n <= 1){
            return n;
        }else if(this.cache.get(n) != null){
            return this.cache.get(n);
        }

        final long result = fib(n-1) + fib(n-2);
        this.cache.put(n,result);

        return result;

    }

}
