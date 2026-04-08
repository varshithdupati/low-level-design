package Problems.TrafficControlSystem.state.intersection;

import Problems.TrafficControlSystem.TrafficIntersection;

public class EastWestGreenState implements IntersectionState {

    private TrafficIntersection intersection;

    public EastWestGreenState(TrafficIntersection intersection) {
        this.intersection = intersection;
    }

    @Override
    public void changeState() throws InterruptedException {

        intersection.getEastLight().setGreenState();
        intersection.getWestLight().setGreenState();
        intersection.getNorthLight().setRedState();
        intersection.getSouthLight().setRedState();
        System.out.println("East-West direction is GREEN. North-South direction is RED.");

        Thread.sleep(intersection.getGreenDuration());

        intersection.getEastLight().changeState();
        intersection.getWestLight().changeState();
        System.out.println("East-West direction is YELLOW. North-South direction is RED.");

        Thread.sleep(intersection.getYellowDuration());

        intersection.getEastLight().changeState();
        intersection.getWestLight().changeState();
        System.out.println("East-West direction is RED. North-South direction is RED.");

        intersection.setState(intersection.getNorthSouthGreenState());

    }

}
