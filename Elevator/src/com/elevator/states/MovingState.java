package com.elevator.states;

import com.elevator.Elevator;

public class MovingState extends State {

    public MovingState(Elevator elevator) {
        super(elevator);

    }

    @Override
    public String OnMove() {
        //находится в движении
        return "Locked";
    }

    @Override
    public String onStop() {
        //останавливается если прошло 10 сек И если на находится на нужном(нажатом) этаже
        if(elevator.getCurrentFloor() == elevator.getDestinationFloor()) {
            elevator.setState(new StoppedState(elevator));
        }
        return "Reached destination floor";
    }

    @Override
    public String onStart() {
        //не может стартовать т.к. двигается
        return "Locked";
    }
}
