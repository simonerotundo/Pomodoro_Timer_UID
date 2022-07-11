package com.example.PomodoroTimer_UID;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class ActivityHandler {

    /* Singleton */
    private static ActivityHandler instance = null;
    public static ActivityHandler getInstance(){

        if (instance==null)
            instance = new ActivityHandler();

        return instance;

    }


    /* Contains the Current Activity's ID (0: DEFAULT, 1: FOCUS, 2: SHORT BREAK, 3: LONG BREAK) */
    public SimpleIntegerProperty currentActivity = new SimpleIntegerProperty(0);
    public SimpleIntegerProperty currentActivityProperty() { return currentActivity; }
    public int  getCurrentActivity() {
        return currentActivity.get();
    }
    public void setCurrentActivity(int activity) {
        this.currentActivity.set(activity);
    }

    /* Return true if the current activity is a Pomodoro, return false otherwise */
    public boolean itIsAPomodoro(){
        return getCurrentActivity() == 1;
    }

    /* Return true if the current activity is a Break (Short or Long), return false otherwise */
    public boolean itIsBreak(){
        return getCurrentActivity() == 2 || getCurrentActivity() == 3;
    }


    /* Start the new activity */
    public void startNextActivity(){

        /* If the activity just finished was a Pomodoro ..  */
        if(currentActivity.get() == 1) {

            /* .. if I have at least one pomodoro, and the number of my pomodoros are multiple of 4 .. */
            if(ControllerHandler.getInstance().getNumberOfPomodoros() % 4 == 0  &&  ControllerHandler.getInstance().getNumberOfPomodoros() > 0) {

                System.out.println(LanguageHandler.getInstance().NEXT_ACTIVITY + " " + LanguageHandler.getInstance().ACTIVITY_NAMES[LanguageHandler.getInstance().LONG_BREAK_ID]);
                Activity.getInstance().onLongBreakActivity();   // .. switch to long break

            }

            /* .. if I don't have any pomodoros, or the number of ones that I have isn't multiple of 4 .. */
            else {

                System.out.println(LanguageHandler.getInstance().NEXT_ACTIVITY + " " + LanguageHandler.getInstance().ACTIVITY_NAMES[LanguageHandler.getInstance().SHORT_BREAK_ID]);
                Activity.getInstance().onShortBreakActivity();  // .. switch to short break

            }

        }

        /* If the activity just finished was a Break (Short or Long) .. */
        else if(ActivityHandler.getInstance().getCurrentActivity() == 2 || ActivityHandler.getInstance().getCurrentActivity() == 3) {

            System.out.println(LanguageHandler.getInstance().NEXT_ACTIVITY + " " + LanguageHandler.getInstance().ACTIVITY_NAMES[LanguageHandler.getInstance().POMODORO_ID]);
            Activity.getInstance().onFocusActivity();   // .. switch to pomodoro

        }

    }

    /* Show an Alert */
    public boolean showAlert() {

        Alert interruptActivityAlert = new Alert(Alert.AlertType.CONFIRMATION);                             // initialize the aler

        interruptActivityAlert.setHeaderText(LanguageHandler.getInstance().getConfirmationString());        // set the alert's header
        interruptActivityAlert.setContentText(LanguageHandler.getInstance().getAlertConfirmationString());  // set the alert's content

        /* Show the alert and stores the button on which the user click */
        Optional<ButtonType> choise = interruptActivityAlert.showAndWait();

        /* Decide how to act based on the choice made */
        if(!choise.isPresent())                    { return false; } // alert is exited, no button has been pressed  ->  return false
        else if(choise.get() == ButtonType.OK)     { return true; }  // ok button is pressed                         ->  return true
        else if(choise.get() == ButtonType.CANCEL) { return false; } // cancel button is pressed                     ->  return false
        else                                       { return false; } // default return


    }

}
