package Observer;
import Subject.*;

public class ConcreteObserver implements ObserverClass {
    private int observerState;
    private ConcreteSubject subject;

    public ConcreteObserver(ConcreteSubject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    public void update() {
        observerState = subject.getState();
        System.out.println("Observer state updated: " + observerState);
    }
}



