package Problems.TrafficControlSystem.state.light;

import Problems.TrafficControlSystem.TrafficLight;

public class GreenState implements LightState {
    
    private TrafficLight trafficLight;

    public GreenState(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    @Override
    public void changeState() {
        System.out.println("Changing from GREEN to YELLOW");
        trafficLight.setState(trafficLight.getYellowState());
    }
    
}
