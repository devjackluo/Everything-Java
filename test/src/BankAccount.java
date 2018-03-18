public class BankAccount {

    private int balance;

    public BankAccount(int startBalance){
        balance = startBalance;
    }

    public synchronized int getBalance(){
        return balance;
    }

    /* synchronized method
    public synchronized void deposit(int amount){
        balance += amount;
    }
    */

    public void deposit(int amount){
        balance += amount;
    }

}
