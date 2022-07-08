package com.example.timer_test_24062022;

public class Time {

    private static Time instance = null;
    public static Time getInstance(){
        if (instance==null)
            instance = new Time();
        return instance;
    }


    public int secondsToMinutes(int seconds) { return seconds * 60; }
    public String secondsToMinutesAndSeconds() {

        String formatted_MMSS = "";
        int secondsElapsed = Timer.getInstance().getTempo();
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

    } // String formatter -> MM:SS

}
