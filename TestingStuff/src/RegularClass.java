public class RegularClass extends AbstractClassA implements DefaultMethodInterface{

    private String outerClassString = "Only my family has access to me!";
    private NestedClass nc = new NestedClass("String");

    @Override
    public void implementMe() {
        abstractVariableNotInitialized = "You don't have to initilize variable with abstract classes but have to with interface.";
        System.out.println(abstractVariable);
        System.out.println(abstractVariableNotInitialized);
        printHello();
    }


    @Override
    public void printImplement() {
        System.out.println("Printing forced interface implementation method plus interface value: " + useMeInt);
        printDefault();
        NestedClass nc = new NestedClass("Nested Class likes to say hello!");
        System.out.println(nc.visibleVar);
        System.out.println("InnerClass use outerclassstring: " + nc.innerClassString);
    }

    //static block always runs when class is created
    static {
        System.out.println("Regular: Static block method runs/compiles before any other code runs");
    }


    //Nested class can only be created within the outer class.
    public class NestedClass<T>{

        public T visibleVar;
        public String innerClassString;

        public NestedClass(T v){
            visibleVar = v;
            innerClassString = outerClassString;
        }

    }

}
