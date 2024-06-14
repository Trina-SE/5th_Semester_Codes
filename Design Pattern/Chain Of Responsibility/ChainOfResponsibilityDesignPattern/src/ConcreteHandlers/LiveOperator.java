package ConcreteHandlers;
import Handlers.*;

public class LiveOperator extends BaseHandler {
    @Override
    public void handle(Request request) {
        System.out.println("Live Operator: Reading from the manual...");
        // Simulate the operator's inability to help
        boolean canHandle = false; // Simulate that the operator cannot handle it
        if (!canHandle) {
            super.handle(request);
        }
    }
}
