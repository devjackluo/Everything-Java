package Singleton;

public class DbSingleton {

    private static volatile DbSingleton instance = null;

    private DbSingleton(){
        if(instance != null ){
            throw new RuntimeException("Use getInstance");
        }
    }

    public static DbSingleton getInstance(){

        //lazy load
        if(instance == null){
            //multiple threads could be waiting here, therefore need another check inside
            synchronized (DbSingleton.class) {
                if(instance == null) {
                    instance = new DbSingleton();
                }
            }
        }

        return instance;
    }

}
