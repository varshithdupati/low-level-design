package Problems.TrafficControlSystem;

import Problems.TrafficControlSystem.state.light.GreenState;
import Problems.TrafficControlSystem.state.light.LightState;
import Problems.TrafficControlSystem.state.light.RedState;
import Problems.TrafficControlSystem.state.light.YellowState;
import Problems.TrafficControlSystem.enums.Direction;

public class TrafficLight implements LightState {
    
    private LightState redState;
    private LightState yellowState;
    private LightState greenState;
    
    private LightState currentState;
    private String id;
    private Direction direction;

    public TrafficLight(String id, Direction direction) {
        this.id = id;
        this.direction = direction;
        this.redState = new RedState(this);
        this.yellowState = new YellowState(this);
        this.greenState = new GreenState(this);
        this.currentState = redState; // Initial state
    }

    @Override
    public void changeState() {
        currentState.changeState();
    }

    public void setState(LightState state) {
        this.currentState = state;
    }

    public void setGreenState() {
        this.currentState = greenState;
    }

    public void setRedState() {
        this.currentState = redState;
    }

    public LightState getRedState() {
        return redState;
    }

    public LightState getYellowState() {
        return yellowState;
    }

    public LightState getGreenState() {
        return greenState;
    }

    public String getId() {
        return id;
    }

    public Direction getDirection() {
        return direction;
    }

}
