package com.example.timer_test_24062022;

import javafx.scene.control.Label;

public class TimeLabelHandler {

    public static void refresh(Label timerLabel) {

        // Aggiorna il valore del Label utilizzanado un il formato MM:SS
        timerLabel.setText(secondsToMinutesAndSeconds());

    }
    public static String secondsToMinutesAndSeconds(){

        String formatted_MMSS = "";
        int secondsElapsed = Timer.getSecondsElapsed();
        int minutesElapsed;


        // Effettua la conversione da secondi a minuti
        minutesElapsed =  secondsElapsed / 60;
        secondsElapsed -= minutesElapsed * 60;


        // Memorizza la stringa nel formato MM:SS
        if(minutesElapsed >= 0 && minutesElapsed <=9) { formatted_MMSS += "0"; }
        formatted_MMSS += Integer.toString(minutesElapsed);

        formatted_MMSS += ":";

        if(secondsElapsed >= 0 && secondsElapsed <=9) { formatted_MMSS += "0"; }
        formatted_MMSS += Integer.toString(secondsElapsed);


        // Restituisce la stringa formattata correttamente
        return formatted_MMSS;

    }

}
