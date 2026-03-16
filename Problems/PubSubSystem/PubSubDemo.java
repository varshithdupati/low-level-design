package Problems.PubSubSystem;

public class PubSubDemo {
    
    public static void main(String[] args) throws InterruptedException {

        PubSubService pubSubService = PubSubService.getInstance();
        
        pubSubService.createTopic("sports");
        pubSubService.createTopic("technology");
        
        Subscriber subscriber1 = new SimpleSubscriber("Subscriber 1");
        Subscriber subscriber2 = new SimpleSubscriber("Subscriber 2");
        
        pubSubService.subscribe("sports", subscriber1);
        pubSubService.subscribe("technology", subscriber1);
        pubSubService.subscribe("sports", subscriber2);
        
        pubSubService.publish("sports", "Football match tonight!");
        Thread.sleep(500); // Sleep to allow async messages to be printed
        pubSubService.publish("technology", "New smartphone released!");

        pubSubService.shutdown();

    }

}
