public class Worker implements Runnable{

    private BankAccount account;

    public Worker(BankAccount account){
        this.account = account;
    }

    @Override
    public void run() {

        /*
        //int startBalance = account.getBalance();
        for(int i = 0; i < 1000000; i++) {
            account.deposit(10);
        }
        //int endBalance = account.getBalance();
        */


        // synchronized statement blocks
        for(int i = 0; i < 1000000; i++) {
            synchronized (account) {
                account.deposit(10);
            }
        }

    }


}
