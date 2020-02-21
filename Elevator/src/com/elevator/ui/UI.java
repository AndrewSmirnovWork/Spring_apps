package com.elevator.ui;

import javax.swing.*;
import java.awt.*;

public class UI {

        private Elevator elevator;
        private static JTextField textField = new JTextField();

        public UI(Elevator elevator) {
            this.elevator = elevator;
        }

        public void init() {
            JFrame frame = new JFrame("Test elevator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel context = new JPanel();
            context.setLayout(new BoxLayout(context, BoxLayout.Y_AXIS));
            frame.getContentPane().add(context);
            JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
            context.add(textField);
            context.add(buttons);

            // Контекст заставляет состояние реагировать на пользовательский ввод
            // вместо себя. Реакция может быть разной в зависимости от того, какое
            // состояние сейчас активно.
            JButton firstFloor = new JButton("1");
            firstFloor.addActionListener(e -> textField.setText(elevator.getState().onStart()));
            firstFloor.addActionListener(e -> elevator.setDestinationFloor(1));
            JButton secondFloor = new JButton("2");
            secondFloor.addActionListener(e -> textField.setText(elevator.getState().onStart()));
            secondFloor.addActionListener(e -> elevator.setDestinationFloor(2));
            JButton thirdFloor = new JButton("3");
            thirdFloor.addActionListener(e -> textField.setText(elevator.getState().onStart()));
            thirdFloor.addActionListener(e -> elevator.setDestinationFloor(3));
            JButton fourthFloor = new JButton("4");
            fourthFloor.addActionListener(e -> textField.setText(elevator.getState().onStart()));
            fourthFloor.addActionListener(e -> elevator.setDestinationFloor(4));
            frame.setVisible(true);
            frame.setSize(300, 100);
            buttons.add(firstFloor);
            buttons.add(secondFloor);
            buttons.add(thirdFloor);
            buttons.add(fourthFloor);
        }
    }

