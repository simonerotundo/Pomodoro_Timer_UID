package com.example.PomodoroTimer_UID;

public class Time {

    private static Time instance = null;
    public static Time getInstance(){
        if (instance==null)
            instance = new Time();
        return instance;
    }


    public int minutesToSeconds(int seconds) { return seconds * 60; }

    public String secondsToHoursMinutesSeconds(int seconds) {

        // ss -> mm
        int minutesElapsed = seconds / 60;
        int secondsElapsed = seconds - (minutesElapsed * 60);

        // mm -> hh
        int hoursElapsed = minutesElapsed / 60;
        minutesElapsed -= (hoursElapsed * 60);



        String output = " ";
        int initialStringLength = output.length();

        if(hoursElapsed > 0) {
            output += hoursElapsed + " ";
            if(LanguageHandler.getInstance().getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {
                if(hoursElapsed == 1) {
                    output += ItalianDictionary.getInstance().HOUR;
                }
                else {
                    output += ItalianDictionary.getInstance().HOURS;
                }
            }
            else if (LanguageHandler.getInstance().getPreferredLanguage() == EnglishDictionary.getInstance().LANGUAGE_ID) {
                if(hoursElapsed == 1) {
                    output += EnglishDictionary.getInstance().HOUR;
                }
                else {
                    output += EnglishDictionary.getInstance().HOURS;
                }
            }
        }

        // se ho stampato l'ora, aggiungo una virgola e stampo i minuti anche se sono 0 -> "1 ora, 0 minuti"
        if(output.length() > initialStringLength) {
            output += ", ";

            output += minutesElapsed + " ";
            if(LanguageHandler.getInstance().getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {
                if(minutesElapsed == 1) {
                    output += ItalianDictionary.getInstance().MINUTE;
                }
                else {
                    output += ItalianDictionary.getInstance().MINUTES;
                }
            }
            else if (LanguageHandler.getInstance().getPreferredLanguage() == EnglishDictionary.getInstance().LANGUAGE_ID) {
                if(minutesElapsed == 1) {
                    output += EnglishDictionary.getInstance().MINUTE;
                }
                else {
                    output += EnglishDictionary.getInstance().MINUTES;
                }
            }
        }

        // altrimenti, verifico se i minuti sono più di 0
        else {
            if(minutesElapsed > 0) {
                output += minutesElapsed + " ";

                // traduco l'unità di misura
                if(LanguageHandler.getInstance().getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {
                    if(minutesElapsed == 1) {
                        output += ItalianDictionary.getInstance().MINUTE;
                    }
                    else {
                        output += ItalianDictionary.getInstance().MINUTES;
                    }
                }
                else if (LanguageHandler.getInstance().getPreferredLanguage() == EnglishDictionary.getInstance().LANGUAGE_ID) {
                    if(minutesElapsed == 1) {
                        output += EnglishDictionary.getInstance().MINUTE;
                    }
                    else {
                        output += EnglishDictionary.getInstance().MINUTES;
                    }
                }
            }
        }

        // se ho stampato i minuti, aggiungo una virgola e stampo i secondi anche se sono 0 -> "1 minuto, 0 secondi"
        if(output.length() > initialStringLength) {
            output += ", ";
        }

        output += secondsElapsed + " ";
        if(LanguageHandler.getInstance().getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {
            if(secondsElapsed == 1) {
                output += ItalianDictionary.getInstance().SECOND;
            }
            else {
                output += ItalianDictionary.getInstance().SECONDS;
            }
        }
        else if (LanguageHandler.getInstance().getPreferredLanguage() == EnglishDictionary.getInstance().LANGUAGE_ID) {
            if(secondsElapsed == 1) {
                output += EnglishDictionary.getInstance().SECOND;
            }
            else {
                output += EnglishDictionary.getInstance().SECONDS;
            }
        }

        return output;

    }
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
