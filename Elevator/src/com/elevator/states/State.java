package com.elevator.states;

import com.elevator.Elevator;

//current elevator states
public abstract class State {
    public Elevator elevator;

    public State(Elevator elevator) {
        this.elevator = elevator;
    }

    public abstract String OnMove();// лифт в движении 10 секунд

    public abstract String onStop();// лифт стоит 2 секунды

    public abstract String onStart();//лифт начинает двигаться через 2 секунды

}
