package com.example.PomodoroTimer_UID;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Timer {

    /* Singleton */
    private static Timer instance = null;
    public static Timer getInstance(){

        if (instance==null)
            instance = new Timer();

        return instance;

    }



    /* Timer duration (in seconds) */
    public SimpleIntegerProperty tempo = new SimpleIntegerProperty(0);
    public SimpleIntegerProperty tempoProperty() {
        return tempo;
    }
    public int getTempo() {
        return tempo.get();
    }
    public void setTempo(int tempo) {
        this.tempo.set(tempo);
    }
    private void decrementTempo(){
        tempo.set(tempo.get()-1);
    }



    /* Time spent on focusing */
    public SimpleIntegerProperty tempoConcentrazione = new SimpleIntegerProperty(0);
    public SimpleIntegerProperty tempoConcentrazioneProperty() {
        return tempoConcentrazione;
    }
    public int getTempoConcentrazione() {
        return tempoConcentrazione.get();
    }
    private void incrementTempoConcentrazione() { tempoConcentrazione.set(tempoConcentrazione.get()+1); }


    /* Time spent on Break */
    public SimpleIntegerProperty tempoPausa = new SimpleIntegerProperty(0);
    public SimpleIntegerProperty tempoPausaProperty() {
        return tempoPausa;
    }
    public int getTempoPausa() {
        return tempoPausa.get();
    }
    private void incrementTempoPausa() { tempoPausa.set(tempoPausa.get()+1); }


    private Timeline timeline;  // Timeline initialization

    /* Start the Timer */
    public void startTimer(){

        // For every second that passes ..
        timeline = new Timeline(new KeyFrame(Duration.seconds(1),
                e -> {

                    // .. if the Timer has not run out ..
                    if(tempo.get() > 0) {
                        decrementTempo();                       // .. decrement a second

                        // if it is a Pomodoro ..
                        if(ActivityHandler.getInstance().itIsAPomodoro()) {
                            incrementTempoConcentrazione();     // .. increment Focus Time
                        }

                        // if it is not (it is a Break) ..
                        else {
                            incrementTempoPausa();              // .. increment Break Time
                        }
                    }

                    // if it is ..
                    else {

                        // if Audio Enabler CheckBox is checked ..
                        if(ControllerHandler.getInstance().getEnableAudio()){
                            Audio.getInstance().playAudio();    // .. play the chosen sound effect
                        }

                        Timer.getInstance().pauseTimer();                               // .. pause the timer
                        ControllerHandler.getInstance().setTimerAlreadyStarted(false);  // .. set that the timer has expired

                        /* if the activity that has just ended was a pomodoro .. */
                        if(ActivityHandler.getInstance().itIsAPomodoro()) {

                            ControllerHandler.getInstance().incrementNumberOfPomodoros();   // .. increase number of pomodoros

                            /* if the autorun breaks is set to enable .. */
                            if (ControllerHandler.getInstance().getAutoRunBreaks()) {

                                ActivityHandler.getInstance().startNextActivity();              // .. switch to the next activity
                                Timer.getInstance().startTimer();                               // .. start the timer
                                ControllerHandler.getInstance().setTimerAlreadyStarted(true);   // .. set that the timer is running

                            }

                            /* if the autorun breaks is set to disable .. */
                            else {

                                ControllerHandler.getInstance().updateStartButtonTextToStart(); // .. switch to the next activity
                                ActivityHandler.getInstance().startNextActivity();              // .. start the new activity

                            }

                        }

                        /* if the activity that has just ended was a break ..  */
                        else {

                            /* if the autorun pomodoros is set to enable .. */
                            if (ControllerHandler.getInstance().getAutoRunPomodoro()) {

                                ActivityHandler.getInstance().startNextActivity();              // .. switch to the next activity
                                Timer.getInstance().startTimer();                               // .. start the timer
                                ControllerHandler.getInstance().setTimerAlreadyStarted(true);   // .. set that the timer is running

                            }

                            /* if the autorun pomodoros is set to disable .. */
                            else {

                                ControllerHandler.getInstance().updateStartButtonTextToStart(); // .. switch to the next activity
                                ActivityHandler.getInstance().startNextActivity();              // .. start the new activity

                            }

                        }
                    }

                }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }

    // Pause the Timer
    public void pauseTimer(){
        timeline.pause();
    }

}
