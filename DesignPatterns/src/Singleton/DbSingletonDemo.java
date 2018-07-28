package Singleton;

public class DbSingletonDemo {

    public static void main(String[] args){

        DbSingleton instance = DbSingleton.getInstance();

        //DbSingleton test = new DbSingleton();
        DbSingleton instance2 = DbSingleton.getInstance();

        System.out.println(instance);
        System.out.println(instance2);

    }

}
