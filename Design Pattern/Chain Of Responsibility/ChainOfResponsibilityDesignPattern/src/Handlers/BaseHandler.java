package Handlers;

public abstract class BaseHandler implements Handler {
    private Handler nextHandler;

    public Handler setNext(Handler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    @Override
    public void handle(Request request) {
        if (nextHandler != null) {
            nextHandler.handle(request);
        }
    }
}
