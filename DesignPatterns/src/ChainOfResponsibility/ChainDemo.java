package ChainOfResponsibility;

public class ChainDemo {

    public static void main(String[] args){

        //seperating duty between multiple classes that handle different hierarchy of requests.

        Director bryan = new Director();
        VP crystal = new VP();
        CEO jeff = new CEO();

        bryan.setSuccessor(crystal);
        crystal.setSuccessor(jeff);

        Request request = new Request(RequestType.CONFERENCE, 5000000);
        bryan.handleRequest(request);
        request = new Request(RequestType.PURCHASE, 1400);
        bryan.handleRequest(request);
        request = new Request(RequestType.PURCHASE, 1500);
        bryan.handleRequest(request);

    }

}
