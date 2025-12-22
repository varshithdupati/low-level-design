package ObserverPattern;

import java.util.*;

public class WeatherSubject implements Subject {
    
    List<Observer> subscribers;

    public WeatherSubject() {
        subscribers = new ArrayList<>();
    }

    public void subscribe(Observer observer) {
        subscribers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        subscribers.remove(observer);
    }

    public void notifySubscribers() {
        for(Observer observer: subscribers) {
            observer.update();
        }
    }

}
