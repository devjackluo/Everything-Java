package ChainOfResponsibility;

public class CEO extends Handler {
    @Override
    public void handleRequest(Request request) {
        System.out.println("CEOs should handle purchases above 1500 or anything the others can't");
    }
}
