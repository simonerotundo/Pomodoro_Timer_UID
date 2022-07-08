package com.example.timer_test_24062022;

import javafx.beans.property.SimpleIntegerProperty;
import com.example.timer_test_24062022.Activity;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class ActivityHandler {

    private static ActivityHandler instance = null;
    public static ActivityHandler getInstance(){

        if (instance==null)
            instance = new ActivityHandler();

        return instance;

    }


    /* ATTIVITÀ CORRENTE (0: DEFAULT, 1: FOCUS, 2: SHORT BREAK, 3: LONG BREAK) */
    public SimpleIntegerProperty currentActivity = new SimpleIntegerProperty(0);        // activity di default quando clicco start senza selezionare una modalità
    public SimpleIntegerProperty currentActivityProperty() { return currentActivity; }
    public int  getCurrentActivity() {
        return currentActivity.get();
    }
    public void setCurrentActivity(int activity) {
        this.currentActivity.set(activity);
    }

    public boolean itIsAPomodoro(){
        return currentActivity.get() == 1;
    }

    /* Passa all'attività successiva */
    public void startNextActivity(){

        /* QUALE ATTIVITÀ È APPENA TERMINATA? */

        // Pomodoro -> (Short Break/Long Break)
        if(currentActivity.get() == 1) {

            // SHORT BREAK OR LONG BREAK
            if(ControllerHandler.getInstance().getNumberOfPomodoros() % 4 == 0  &&  ControllerHandler.getInstance().getNumberOfPomodoros() > 0) {

                // LONG BREAK
                System.out.println("Next Activity LBREAK");
                Activity.getInstance().onLongBreakActivity();

            }
            else {

                // SHORT BREAK
                System.out.println("Next Activity SBREAK");
                Activity.getInstance().onShortBreakActivity();

            }

        }
        else if(ActivityHandler.getInstance().getCurrentActivity() == 2  ||  ActivityHandler.getInstance().getCurrentActivity() == 3) {

            // POMODORO
            System.out.println("Next Activity POMODORO");
            Activity.getInstance().onFocusActivity();

        }
        else { /* TODO: 29/06/2022 TEST */ }


    }

    /* show alert */
    public boolean showAlert() {

        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText("Are you sure you want to interrupt the current activity?");

        Optional<ButtonType> choise = a.showAndWait();
        if(!choise.isPresent()){ return false; } // alert is exited, no button has been pressed.
        else if(choise.get() == ButtonType.OK){ return true; } //ok button is pressed
        else if(choise.get() == ButtonType.CANCEL){ return false; } // cancel button is pressed

        return false;

    }

}
