public abstract class AbstractClassA {

    int abstractVariable = 10000;
    String abstractVariableNotInitialized;

    public abstract void implementMe();

    public void printHello(){
        System.out.println("Hello from abstract method");
    }


    //static block always runs when class is created
    static {
        System.out.println("\n\nAbstract classes's Static block method runs/compiles before any code runs");
        System.out.println("Abstract is being inherited so it much be compiled first");
    }

}
