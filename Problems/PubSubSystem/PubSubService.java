package Problems.PubSubSystem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PubSubService {

    private static final PubSubService INSTANCE = new PubSubService();
    private ExecutorService executor;
    private Map<String, Topic> topics;

    private PubSubService() {
        executor = Executors.newCachedThreadPool();
        topics = new ConcurrentHashMap<>();
    }

    public static synchronized PubSubService getInstance() {
        return INSTANCE;
    }

    public Topic createTopic(String topicName) {
        topics.putIfAbsent(topicName, new Topic(topicName, executor));
        return topics.get(topicName);
    }

    public Topic getTopic(String topicName) {
        return topics.get(topicName);
    }

    public Map<String, Topic> getTopics() {
        return topics;
    }

    public void subscribe(String topicName, Subscriber subscriber) {
        Topic topic = topics.getOrDefault(topicName, null);
        if (topic == null) {
            throw new IllegalArgumentException("Topic does not exist: " + topicName);
        }
        topic.subscribe(subscriber);
    }

    public void unsubscribe(String topicName, Subscriber subscriber) {
        Topic topic = topics.getOrDefault(topicName, null);
        if (topic == null) {
            throw new IllegalArgumentException("Topic does not exist: " + topicName);
        }
        topic.unsubscribe(subscriber);
    }

    public void publish(String topicName, String message) {
        Topic topic = topics.getOrDefault(topicName, null);
        if (topic == null) {
            throw new IllegalArgumentException("Topic does not exist: " + topicName);
        }
        topic.broadcast(message);
    }

    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

}
