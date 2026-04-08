package Problems.TrafficControlSystem.state.light;

import Problems.TrafficControlSystem.TrafficLight;

public class YellowState implements LightState {
    
    private TrafficLight trafficLight;

    public YellowState(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    @Override
    public void changeState() {
        System.out.println("Changing from YELLOW to RED");
        trafficLight.setState(trafficLight.getRedState());
    }

}
