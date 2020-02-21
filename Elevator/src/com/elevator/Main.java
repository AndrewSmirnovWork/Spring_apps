package com.elevator;

import com.elevator.ui.Elevator;
import com.elevator.ui.UI;

public class Main {

    public static void main(String[] args) {
        Elevator elevator = Elevator.getInstance();
        UI ui = new UI(elevator);
        ui.init();
	// write your code here
    }
}
