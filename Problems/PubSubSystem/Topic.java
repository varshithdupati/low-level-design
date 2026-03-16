package Problems.PubSubSystem;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;

public class Topic {
    
    private String name;
    private ExecutorService executor;
    private Set<Subscriber> subscribers;

    public Topic(String name, ExecutorService executor) {
        this.name = name;
        this.executor = executor;
        subscribers = new CopyOnWriteArraySet<>();
    }

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void broadcast(String message) {
        for (Subscriber subscriber : subscribers) {
            executor.submit(() -> {
                try {
                    subscriber.receive(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public String getName() {
        return name;
    }

}
