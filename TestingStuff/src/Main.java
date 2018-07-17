import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String [] args)
    {


        double db = 0.0000090000090788912412412422353141242412;

        String[] split = Double.toString(db).split("E");
        System.out.println(split[0]);
        System.out.println(split[1]);

        String remake = split[0] + "E" + Integer.toString(Integer.parseInt(split[1])+1);
        //String remake = split[0] + "E" + "6";
        System.out.println(remake);
        double rdb = Double.parseDouble(remake);
        System.out.println(Double.toString(rdb));
        System.out.println(Double.toString(db));


        //THREADING
        ExecutorService es = Executors.newFixedThreadPool(6);
        BankAccount account = new BankAccount(100);

        for(int i = 0; i < 9; i++) {
            Worker worker = new Worker(account);
            es.submit(worker);
        }

        try {
            es.shutdown();
            es.awaitTermination(100000, TimeUnit.MINUTES);
        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println(account.getBalance());




        //Queue Calculator
        Calculator cal = new Calculator();
        int result = cal.evalute("1 + 2 + 10 * 2");
        System.out.println(result);







        ////TEST ABSTRACT
        RegularClass r = new RegularClass();
        System.out.println("\n\nAbstract/Interface testing  \n\n");
        r.implementMe();
        r.printImplement();
        System.out.println("You can also call default interface methods from inherited class level but not static");
        r.printDefault();


    }

    //static block always runs when class is created
    static {
        System.out.println("Main static block");
    }


}
