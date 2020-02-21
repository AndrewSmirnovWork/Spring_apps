package com.elevator.ui;


import com.elevator.states.State;
import com.elevator.states.StoppedState;

import java.util.ArrayList;

//7 floor
//floor per 10 sek
//2 sek to stop/star elevator
public class Elevator {

    // Начинает ехать с первого этажа, т.е. изначально movingUp = true?>?>?
    // т.е. может ехать только вниз\вверх, по пути останавливаясь на нажатом этаже.
    // Одновременно может быть нажато 7 кнопок, и они должны сбрасываться при прибытие на нужный этаж
    // Что если лифт едет не на первый этаж, а выше\ниже? пока сделаем вид что он едет всегда на первый этаж
    private State state;

    //можно сделать через switch:
    //up, down, waiting
    private boolean movingUp;
    private boolean waiting; //чтобы не использовать Thread.sleep


    private int currentFloor;

    private int destinationFloor;

    private final ArrayList<Integer> queue = new ArrayList<>(7);

    public Elevator() {
        this.state = new StoppedState(this);
        currentFloor = 1;
    }

    public int moving() {
        if(this.movingUp){
            setCurrentFloor(this.currentFloor++);
        }else this.setCurrentFloor(this.currentFloor++);
        return currentFloor;
    }
    public ArrayList<Integer> addingAnotherFloor(int nextFloor) {
        queue.add(nextFloor);
        return queue;
    }

    public boolean isWaiting() {
        return waiting;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean isMovingUp() {
        return movingUp;
    }

    public void setMovingUp(boolean movingUp) {
        this.movingUp = movingUp;
    }


    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }
}
