package ConcreteHandlers;
import Handlers.*;

public class Autoresponder extends BaseHandler {
    @Override
    public void handle(Request request) {
        System.out.println("Autoresponder: Suggesting popular solutions...");
        
        boolean solutionFound = false; 
        if (!solutionFound) {
            super.handle(request);
        }
    }
}
