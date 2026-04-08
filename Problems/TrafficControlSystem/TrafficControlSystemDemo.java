package Problems.TrafficControlSystem;

public class TrafficControlSystemDemo {
    
    public static void main(String[] args) throws InterruptedException {
        TrafficIntersection intersection = new TrafficIntersection.Builder("Intersection-1")
                .setDurations(10000, 4000) // 10 seconds green duration, 4 seconds yellow duration
                .build();
        intersection.start();

        // Let the traffic control system run for a while
        Thread.sleep(30000); // Run for 30 seconds

        // Stop the traffic control system
        intersection.stop();
    }
}
