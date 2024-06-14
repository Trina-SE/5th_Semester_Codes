package Subject;
import Observer.*;

public interface Subject {
	    void attach(ObserverClass observer);
	    void detach(ObserverClass observer);
	    void notifyObservers();
	    int getState();
	}


