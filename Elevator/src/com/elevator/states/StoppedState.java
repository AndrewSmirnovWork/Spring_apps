package com.elevator.states;

import com.elevator.ui.Elevator;

public class StoppedState extends State {

    public StoppedState(Elevator elevator) {
        super(elevator);
        System.out.println("Changing into StoppedState");
        elevator.setWaiting(true);
    }

    @Override
    public void onMove() {
        elevator.setState(new MovingState(elevator));
    }

    @Override
    public String onStop() {
        return "Locked";
    }

    @Override
    public String onStart() {
        if (this.elevator.getCurrentFloor() == this.elevator.getDestinationFloor()) {
            System.out.println("Reached destination floor");
            return "In dat floor already";
        } else {
            elevator.setMovingUp(true);
            this.onMove();
            System.out.println("Going ");
            /*if (elevator.getCurrentFloor() > elevator.getDestinationFloor()) {
                elevator.setMovingUp(false);
            } else {
                elevator.setMovingUp(true);
            }*/
        }
        return "Going to floor " + elevator.getDestinationFloor();
    }
}
