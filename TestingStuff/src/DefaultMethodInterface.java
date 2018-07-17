public interface DefaultMethodInterface {

    int useMeInt = 10;

    void printImplement();

    static void printStatic(){
        System.out.println("Called by default, You can only use static interface methods inside interface");
    }

    default void printDefault(){
        System.out.println("Implemented interface method called me, the default interface method!");
        printStatic();
    }



}
