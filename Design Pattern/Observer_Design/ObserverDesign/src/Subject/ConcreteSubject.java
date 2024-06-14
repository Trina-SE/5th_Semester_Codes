package Subject;
import Observer.*;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {
    private int state;
    private List<ObserverClass> observers = new ArrayList<>();

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }

    public void attach(ObserverClass observer) {
        observers.add(observer);
    }

    public void detach(ObserverClass observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (ObserverClass observer : observers) {
            observer.update();
        }
    }

    public int getState() {
        return state;
    }
}

