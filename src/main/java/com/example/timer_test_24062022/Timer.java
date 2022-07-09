package com.example.timer_test_24062022;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Timer {

    private Timeline timeline;
    private static Timer instance = null;

    public static Timer getInstance(){

        if (instance==null)
            instance = new Timer();

        return instance;

    }

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



    // FOCUS TIME
    public SimpleIntegerProperty tempoConcentrazione = new SimpleIntegerProperty(0);
    public SimpleIntegerProperty tempoConcentrazioneProperty() {
        return tempoConcentrazione;
    }
    public int getTempoConcentrazione() {
        return tempoConcentrazione.get();
    }
    public void setTempoConcentrazione(int tempoConcentrazione) {
        this.tempoConcentrazione.set(tempoConcentrazione);
    }
    private void incrementTempoConcentrazione() { tempoConcentrazione.set(tempoConcentrazione.get()+1); }


    // BREAK TIME
    public SimpleIntegerProperty tempoPausa = new SimpleIntegerProperty(0);
    public SimpleIntegerProperty tempoPausaProperty() {
        return tempoPausa;
    }
    public int getTempoPausa() {
        return tempoPausa.get();
    }
    public void setTempoPausa(int tempoPausa) {
        this.tempoPausa.set(tempoPausa);
    }
    private void incrementTempoPausa() { tempoPausa.set(tempoPausa.get()+1); }


    public void startTimer(){

        // thread run
        timeline = new Timeline(new KeyFrame(Duration.seconds(1),
                e -> {

                    if(tempo.get() > 0) {
                        decrementTempo();    // .. decrementa di un secondo
                        if(ActivityHandler.getInstance().itIsAPomodoro()) { incrementTempoConcentrazione(); }
                        else { incrementTempoPausa(); }
                    } // se il tempo non è ancora terminato ..
                    else {

                        // AUDIO
                        if(ControllerHandler.getInstance().getEnableAudio()){ Audio.getInstance().playAudio(); }

                        // AUTORUN
                        Timer.getInstance().pauseTimer();
                        ControllerHandler.getInstance().setTimerAlreadyStarted(false);

                        if(ActivityHandler.getInstance().itIsAPomodoro()) {

                            // aumento il numero di pomodori
                            ControllerHandler.getInstance().incrementNumberOfPomodoros();


                            if (ControllerHandler.getInstance().getAutoRunBreaks()) {

                                /* ENABLED */
                                ActivityHandler.getInstance().startNextActivity();

                                Timer.getInstance().startTimer();
                                ControllerHandler.getInstance().setTimerAlreadyStarted(true);

                            }
                            else {

                                /* DISABLED */
                                ControllerHandler.getInstance().updateStartButtonTextToStart();
                                ActivityHandler.getInstance().startNextActivity();

                            }

                        }
                        else {

                            if (ControllerHandler.getInstance().getAutoRunPomodoro()) {

                                /* ENABLED */
                                ActivityHandler.getInstance().startNextActivity();

                                Timer.getInstance().startTimer();
                                ControllerHandler.getInstance().setTimerAlreadyStarted(true);

                            } else {

                                /* DISABLED */
                                ControllerHandler.getInstance().updateStartButtonTextToStart();
                                ActivityHandler.getInstance().startNextActivity();

                            }

                        }
                    } // altrimenti ..

                }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }
    public void pauseTimer(){ timeline.pause(); }

}
