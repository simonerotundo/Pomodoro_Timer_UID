package com.example.PomodoroTimer_UID;

public class Activity {

    /* Singleton */
    private static Activity instance = null;
    public static Activity getInstance() {
        if (instance==null)
            instance = new Activity();
        return instance;
    }


    public void onFocusActivity() {

        final int ACTIVITY_ID = 1;                  // Activity ID
        final int FOCUS_ACTIVITY_DURATION = 25;     // Activity duration (in minutes)

        /* If an activity is running (timer is running out) .. */
        if(ControllerHandler.getInstance().getTimerAlreadyStarted()) {

            boolean confirmSwitch = ActivityHandler.getInstance().showAlert();  // Show an alert which asks you if you really want to interrupt the current activity

            /* If you want to skip to Pomodoro .. */
            if(confirmSwitch) {

                ActivityHandler.getInstance().setCurrentActivity(ACTIVITY_ID);                              // .. set the current activity to 1 (Pomodoro)
                Timer.getInstance().pauseTimer();                                                           // .. interrupt timer
                ControllerHandler.getInstance().setTimerAlreadyStarted(false);                              // .. set the timer's state to "pause"
                Timer.getInstance().setTempo(Time.getInstance().minutesToSeconds(FOCUS_ACTIVITY_DURATION)); // .. set the timer to a Pomodoro activity duration (25 minutes)
                ControllerHandler.getInstance().updateTimerLabelText();                                     // .. update the timer label text
                ControllerHandler.getInstance().updateStartButtonTextToStart();                             // .. update the text of the Start/Pause button with "START"

            }

        }

        /* If there is no activity running .. */
        else {

            ActivityHandler.getInstance().setCurrentActivity(ACTIVITY_ID);                                  // .. set the current activity to 1 (Pomodoro)
            Timer.getInstance().setTempo(Time.getInstance().minutesToSeconds(FOCUS_ACTIVITY_DURATION));     // .. set the timer to a Pomodoro activity duration (25 minutes)
            ControllerHandler.getInstance().updateTimerLabelText();                                         // .. update the timer label text

        }

    }       // ID: 1
    public void onShortBreakActivity() {

        final int ACTIVITY_ID = 2;
        final int SHORTBREAK_ACTIVITY_DURATION = 5;

        if(ControllerHandler.getInstance().getTimerAlreadyStarted()) {

            boolean confirm = ActivityHandler.getInstance().showAlert();

            if(confirm) {

                ActivityHandler.getInstance().setCurrentActivity(2);
                Timer.getInstance().pauseTimer();
                ControllerHandler.getInstance().setTimerAlreadyStarted(false);


                Timer.getInstance().setTempo(Time.getInstance().minutesToSeconds(SHORTBREAK_ACTIVITY_DURATION));

                ControllerHandler.getInstance().updateTimerLabelText();
                ControllerHandler.getInstance().updateStartButtonTextToStart();

            }

        }
        else {

            ActivityHandler.getInstance().setCurrentActivity(ACTIVITY_ID);

            Timer.getInstance().setTempo(Time.getInstance().minutesToSeconds(SHORTBREAK_ACTIVITY_DURATION));

            ControllerHandler.getInstance().updateTimerLabelText();

        }

    }  // ID: 2
    public void onLongBreakActivity() {

        final int ACTIVITY_ID = 3;
        final int LONGBREAK_ACTIVITY_DURATION = 15;

        if(ControllerHandler.getInstance().getTimerAlreadyStarted()) {

            boolean confirm = ActivityHandler.getInstance().showAlert();
            if(confirm) {

                ActivityHandler.getInstance().setCurrentActivity(3);
                Timer.getInstance().pauseTimer();
                ControllerHandler.getInstance().setTimerAlreadyStarted(false);


                Timer.getInstance().setTempo(Time.getInstance().minutesToSeconds(LONGBREAK_ACTIVITY_DURATION));

                ControllerHandler.getInstance().updateTimerLabelText();
                ControllerHandler.getInstance().updateStartButtonTextToStart();

            }

        }
        else {

            ActivityHandler.getInstance().setCurrentActivity(ACTIVITY_ID);

            Timer.getInstance().setTempo(Time.getInstance().minutesToSeconds(LONGBREAK_ACTIVITY_DURATION));

            ControllerHandler.getInstance().updateTimerLabelText();

        }

    }   // ID: 3

}
