package Problems.PubSubSystem;

public class SimpleSubscriber implements Subscriber {
    
    private String name;
    
    public SimpleSubscriber(String name) {
        this.name = name;
    }
    
    @Override
    public void receive(String message) {
        System.out.println(name + " received: " + message);
    }
    
}
