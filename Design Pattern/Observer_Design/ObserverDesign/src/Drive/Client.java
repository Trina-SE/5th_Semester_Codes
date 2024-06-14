package Drive;

import java.security.Key;

import Observer.*;
import Subject.*;

public class Client {
	
    public static void main(String[] args) {
    	
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver observer1 = new ConcreteObserver(subject);
        ConcreteObserver observer2 = new ConcreteObserver(subject);
        ConcreteObserver observer3 = new ConcreteObserver(subject);

        subject.setState(10);

        subject.detach(observer1);

        subject.setState(20);

        subject.detach(observer2); 
        subject.setState(30);
    }
}

