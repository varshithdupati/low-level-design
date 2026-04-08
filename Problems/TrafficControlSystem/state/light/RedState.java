package Problems.TrafficControlSystem.state.light;

import Problems.TrafficControlSystem.TrafficLight;

public class RedState implements LightState {
    
    private TrafficLight trafficLight;

    public RedState(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    @Override
    public void changeState() {
        System.out.println("Changing from RED to GREEN");
        trafficLight.setState(trafficLight.getGreenState());
    }
    
}
