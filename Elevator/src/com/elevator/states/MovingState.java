package com.elevator.states;

import com.elevator.ui.Elevator;

public class MovingState extends State {

    //В состоянии движения лифт едет 10 секунд и проверяет находится ли он на нужном этаже,
    // если да то StoppedState, если нет дальше едет...
    public MovingState(Elevator elevator) {
        super(elevator);
        System.out.println("Creating moving state");
        elevator.setWaiting(false);
        onMove();
    }

    @Override
    public void onMove() {
        elevator.moving();
        System.out.println("calling onStop");
        this.onStop();
    }

    @Override
    public String onStop() {

        if (elevator.getCurrentFloor() == elevator.getDestinationFloor()) {
            System.out.println("calling stop state inside if");
            elevator.setState(new StoppedState(elevator));
        } else {
            System.out.println("calling moving state inside if");
            elevator.setState(new MovingState(elevator));
            return "Stopped";
        }
        return "Stop";
    }

    @Override
    public String onStart() {
        elevator.setState(new StoppedState(elevator));
        //не может стартовать т.к. двигается
        return "Locked, still moving";
    }
}
