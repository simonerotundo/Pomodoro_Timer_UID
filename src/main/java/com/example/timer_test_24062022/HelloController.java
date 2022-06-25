package com.example.timer_test_24062022;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


public class HelloController {

        // Switch timer Buttons
        @FXML private Button focusSwitchButton;
        @FXML private Button ShortBreakSwitchButton;
        @FXML private Button LongBreakSwitchButton;

        @FXML
        void switchToFocus(MouseEvent event) {
                // TODO: 25/06/2022
                /*
                * COSA DEVE FARE:
                *
                * 1. modificare il tema
                * 2. impostare il timer a 25.00
                *
                * */
        }

        @FXML
        void switchToShortBreak(MouseEvent event) {
                // TODO: 25/06/2022
        }

        @FXML
        void switchToLongBreak(MouseEvent event) {
                // TODO: 25/06/2022
        }




        // Timer Label
        @FXML private Label timerLabel;


        // Start timer Button
        @FXML private Button startButton;
        static boolean alreadyStart = false;
        @FXML void startTimer(MouseEvent event) {

                if(!alreadyStart) {
                        alreadyStart = true;
                        System.out.print("Look here -> ");
                        Timer.helloTimer(timerLabel);
                        TimeLabelHandler.refresh(timerLabel);
                }

        }

        @FXML private Button pauseButton;
        @FXML void pauseTimer(MouseEvent event) {

                // come si fa? la timeline viene creata in startTimeline!

        }

        public static void setAlreadyStartToFalse(){ alreadyStart = false; }

}