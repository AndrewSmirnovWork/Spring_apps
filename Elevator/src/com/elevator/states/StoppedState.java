package com.elevator.states;

import com.elevator.ui.Elevator;

public class StoppedState extends State {

    public StoppedState(Elevator elevator) {
        super(elevator);
        System.out.println("Changing into StoppedState");
        elevator.setWaiting(true);

    }

    @Override
    public String onMove() {
        //тут дожна быть переменная которая проверяет движется ли лифт
        return "Can't move, choose floor";
    }

    @Override
    public String onStop() {
        return "Already stopped";
    }

    @Override
    public String onStart() {
        if(this.elevator.getCurrentFloor() == this.elevator.getDestinationFloor()){return "In dat floor already";}
        if(elevator.getCurrentFloor() > elevator.getDestinationFloor()) {
            elevator.setMovingUp(false);
        }else {
            elevator.setMovingUp(true);
        }
        elevator.setState(new MovingState(elevator));
        return "Ready to move";
    }
}
