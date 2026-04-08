package Problems.TrafficControlSystem;

import java.util.HashMap;
import java.util.Map;

import Problems.TrafficControlSystem.enums.Direction;
import Problems.TrafficControlSystem.state.intersection.EastWestGreenState;
import Problems.TrafficControlSystem.state.intersection.IntersectionState;
import Problems.TrafficControlSystem.state.intersection.NorthSouthGreenState;

public class TrafficIntersection implements IntersectionState, Runnable {
    
    private String id;
    private Map<String, TrafficLight> trafficLights;
    private long greenDuration, yellowDuration;

    private IntersectionState currentState;

    private IntersectionState northSouthGreenState;
    private IntersectionState eastWestGreenState;

    private volatile boolean isRunning = true;

    private TrafficIntersection(String id, long greenDuration, long yellowDuration, Map<String, TrafficLight> trafficLights) {
        this.id = id;
        this.greenDuration = greenDuration;
        this.yellowDuration = yellowDuration;
        this.trafficLights = trafficLights;
        this.northSouthGreenState = new NorthSouthGreenState(this);
        this.eastWestGreenState = new EastWestGreenState(this);
        this.currentState = northSouthGreenState; // Initial state
    }

    public void start() {
        new Thread(this).start();
    }

    public void stop() {
        isRunning = false;
    }

    @Override
    public void changeState() throws InterruptedException {
        currentState.changeState();
    }

    public void run() {
        while (isRunning) {
            try {
                changeState();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Traffic intersection " + id + " interrupted. Shutting down.");
                break;
            }
        }
    }

    public void setState(IntersectionState state) {
        this.currentState = state;
    }

    public IntersectionState getNorthSouthGreenState() {
        return northSouthGreenState;
    }

    public IntersectionState getEastWestGreenState() {
        return eastWestGreenState;
    }

    public TrafficLight getNorthLight() {
        return trafficLights.get(id + "_NORTH");
    }

    public TrafficLight getEastLight() {
        return trafficLights.get(id + "_EAST");
    }

    public TrafficLight getSouthLight() {
        return trafficLights.get(id + "_SOUTH");
    }

    public TrafficLight getWestLight() {
        return trafficLights.get(id + "_WEST");
    }

    public long getGreenDuration() {
        return greenDuration;
    }

    public long getYellowDuration() {
        return yellowDuration;
    }

    public static class Builder {
        private String id;
        private long greenDuration = 60000; // Default 60 seconds
        private long yellowDuration = 5000; // Default 5 seconds
        private Map<String, TrafficLight> trafficLights = new HashMap<>();

        public Builder(String id) {
            this.id = id;
        }

        public Builder setDurations(long greenDuration, long yellowDuration) {
            this.greenDuration = greenDuration;
            this.yellowDuration = yellowDuration;
            return this;
        }

        public TrafficIntersection build() {
            for (Direction direction : Direction.values()) {
                String lightId = id + "_" + direction.name();
                trafficLights.put(lightId, new TrafficLight(lightId, direction));
            }
            return new TrafficIntersection(id, greenDuration, yellowDuration, trafficLights);
        }
    }
}
