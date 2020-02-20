package com.elevator.states;

import com.elevator.Elevator;

public class StoppedState extends State {

    public StoppedState(Elevator elevator) {
        super(elevator);
    }

    @Override
    public String OnMove() {
        //тут дожна быть переменная которая проверяет движется ли лифт
        return "Locked";
    }

    @Override
    public String onStop() {
        return "Locked";
    }

    @Override
    public String onStart() {
        if(elevator.getCurrentFloor() > elevator.getDestinationFloor()) {
            elevator.setMovingUp(false);
        }else {
            elevator.setMovingUp(true);
        }
        elevator.setState(new MovingState(elevator));
        return "Start moving";
    }
}
