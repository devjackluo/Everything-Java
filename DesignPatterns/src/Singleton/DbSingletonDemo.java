package Singleton;

public class DbSingletonDemo {

    public static void main(String[] args){

        //Singleton is a global thread safe instance of some object that can be used everywhere
        //where only one can exist in the whole system

        DbSingleton instance = DbSingleton.getInstance();

        //DbSingleton test = new DbSingleton();
        DbSingleton instance2 = DbSingleton.getInstance();

        System.out.println(instance);
        System.out.println(instance2);

    }

}
