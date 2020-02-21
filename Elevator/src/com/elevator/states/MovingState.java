package com.elevator.states;

import com.elevator.ui.Elevator;

public class MovingState extends State {

    //В состоянии движения лифт едет 10 секунд и проверяет находится ли он на нужном этаже,
    // если да то StoppedState, если нет дальше едет...
    public MovingState(Elevator elevator) {
        super(elevator);
        System.out.println("Creating moving state");
        elevator.setWaiting(false);
        //10 sek
        try {
            while (elevator.getCurrentFloor() != elevator.getDestinationFloor()) {
                Thread.sleep(1000);//пока хз как сделать по другому
                System.out.println("waited 10 sek");
                elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
            }
            System.out.println("calling onStop");
            this.onStop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String onMove() {
        //находится в движении
        return "Locked, already moving";
    }

    @Override
    public String onStop() {
        //останавливается если прошло 10 сек И если на находится на нужном(нажатом) этаже
        //если нет, то едет дальше??
        if (elevator.getCurrentFloor() == elevator.getDestinationFloor()) {
            System.out.println("calling stop state inside if");
            elevator.setState(new StoppedState(elevator));
        } else {
            System.out.println("calling moving state inside if");
            elevator.setState(new MovingState(elevator));
        }
        return "Still moving...";
    }

    @Override
    public String onStart() {
        //не может стартовать т.к. двигается
        return "Locked, still moving";
    }
}
