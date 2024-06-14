package ConcreteHandlers;
import Handlers.*;

public class Engineer extends BaseHandler {
    @Override
    public void handle(Request request) {
        System.out.println("Engineer: Providing solution...");
        System.out.println("Download the proper drivers for your new hardware and install them on Linux.");
    }
}
