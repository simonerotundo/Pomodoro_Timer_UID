package com.example.timer_test_24062022;

import javafx.scene.control.Label;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Timer {

    private static final int DEFAULT_TIME = 5;

    static int minutesElapsed = 25;
    static int secondsElapsed = minutesElapsed * 60; // 25 minuti * 60 secondi = 1500 secondi


    public static void startTimer(Label timerLabel){

        // ^^ migliorare in modo che non prenda timerLabel in input ^^

        // thread run
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000),
                e -> {

                    if(secondsElapsed > 0) {
                        decrementSecondsElapsed(); TimeLabelHandler.refresh(timerLabel); System.out.print("*");
                    }
                    else {} // thread interrotto

                }));
        timeline.setCycleCount(Animation.INDEFINITE); // loop forever
        timeline.play();

    }

    public static void pauseTimer(Timeline timeline){

        timeline.pause();

    }

    public static void helloTimer(Label timerLabel){

        /* DEBUG */
        /*
        * ASTERISCO (*) -> Secondo incrementato
        * TRATTINO  (-) -> Pausa per refreshare il display
        *
        */

        startTimer(timerLabel);

    }

    private static void decrementSecondsElapsed(){ secondsElapsed -= 1; }
    public static int getSecondsElapsed(){ return secondsElapsed; }


}
