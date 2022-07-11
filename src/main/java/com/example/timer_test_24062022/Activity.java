package com.example.timer_test_24062022;

public class Activity {

    private static Activity instance = null;
    public static Activity getInstance(){
        if (instance==null)
            instance = new Activity();
        return instance;
    }

    int FOCUS_TEST       = 1;
    int SHORT_BREAK_TEST = 2;
    int LONG_BREAK_TEST  = 3;


    public void onFocusActivity() {

        final int ACTIVITY_ID = 1;
        final int FOCUS_ACTIVITY_DURATION = 25;

        if(ControllerHandler.getInstance().getTimerAlreadyStarted()) {

            boolean confirmSwitch = ActivityHandler.getInstance().showAlert();
            if(confirmSwitch) {

                ActivityHandler.getInstance().setCurrentActivity(1);
                Timer.getInstance().pauseTimer();
                ControllerHandler.getInstance().setTimerAlreadyStarted(false);


                Timer.getInstance().setTempo(Time.getInstance().minutesToSeconds(FOCUS_ACTIVITY_DURATION));

                ControllerHandler.getInstance().updateTimerLabelText(); // 1 - una funzione che setta questo (oppure fare direttamente il setTempo)
                ControllerHandler.getInstance().updateStartButtonTextToStart();

            }

        }
        else {

            ActivityHandler.getInstance().setCurrentActivity(ACTIVITY_ID);

            Timer.getInstance().setTempo(Time.getInstance().minutesToSeconds(FOCUS_ACTIVITY_DURATION));

            ControllerHandler.getInstance().updateTimerLabelText();

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

                ControllerHandler.getInstance().updateTimerLabelText(); // 1 - una funzione che setta questo (oppure fare direttamente il setTempo)
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

                ControllerHandler.getInstance().updateTimerLabelText(); // 1 - una funzione che setta questo (oppure fare direttamente il setTempo)
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
