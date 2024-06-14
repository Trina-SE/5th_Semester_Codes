package Handlers;
import ConcreteHandlers.*;

public class Client {
    public static void main(String[] args) {
        Request request = new Request("Linux refuses to work with the new hardware.");


        BaseHandler autoresponder = new Autoresponder();
        BaseHandler liveOperator = new LiveOperator();
        BaseHandler engineer = new Engineer();

        autoresponder.setNext(liveOperator);
        liveOperator.setNext(engineer);

        System.out.println("Sending request through the chain...");
        autoresponder.handle(request);
    }
}
