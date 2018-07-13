public class SimpleDeadLock {

    private static final Object resourceA = new Object();
    private static final Object resourceB = new Object();

    public static void main(String args[]) throws InterruptedException {

        final Runnable r1 = () -> {
            synchronized (resourceA) {
                System.out.println("Thread 1: Holding lock A...");
                System.out.println("Thread 1: Waiting for lock B...");
                waitForAWhile(5000);
                synchronized (resourceB){
                    System.out.println("Thread 2: holding lock A & B");
                }
            }
        };

        final Runnable r2 = () -> {
            synchronized (resourceB) {
                System.out.println("Thread 2: Holding lock B...");
                System.out.println("Thread 2: Waiting for lock A...");
                waitForAWhile(6000);
                synchronized (resourceA){
                    System.out.println("Thread 2: holding lock A & B");
                }
            }
        };

        final Thread t1 = new Thread(r1);
        final Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("we are done");

    }


    public static void waitForAWhile(final long waitTimeInMillis){
        try{
            Thread.sleep(waitTimeInMillis);
        }catch (final InterruptedException e){

        }
    }

}
