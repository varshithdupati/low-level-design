package Problems.TrafficControlSystem.state.intersection;

import Problems.TrafficControlSystem.TrafficIntersection;

public class NorthSouthGreenState implements IntersectionState {

    private TrafficIntersection intersection;

    public NorthSouthGreenState(TrafficIntersection intersection) {
        this.intersection = intersection;
    }
    
    @Override
    public void changeState() throws InterruptedException {

        intersection.getEastLight().setRedState();
        intersection.getWestLight().setRedState();
        intersection.getNorthLight().setGreenState();
        intersection.getSouthLight().setGreenState();
        System.out.println("North-South direction is GREEN. East-West direction is RED.");

        Thread.sleep(intersection.getGreenDuration());

        intersection.getNorthLight().changeState();
        intersection.getSouthLight().changeState();
        System.out.println("North-South direction is YELLOW. East-West direction is RED.");

        Thread.sleep(intersection.getYellowDuration());

        intersection.getNorthLight().changeState();
        intersection.getSouthLight().changeState();
        System.out.println("North-South direction is RED. East-West direction is RED.");

        intersection.setState(intersection.getEastWestGreenState());

    }

}
