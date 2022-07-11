package com.example.PomodoroTimer_UID;

public class Time {

    /* Singleton */
    private static Time instance = null;
    public static Time getInstance(){
        if (instance==null)
            instance = new Time();
        return instance;
    }



    /* convert minutes into seconds */
    public int minutesToSeconds(int minutes) { return minutes * 60; }


    /* convert seconds into a string similar to " 3 hour, 2 minutes, 1 second" */
    public String secondsToHoursMinutesSeconds(int seconds) {

        /*
        * SOME EXAMPLE:
        *
        * 1 hour, 2 minutes, 3 seconds
        * 2 minutes, 3 seconds
        * 3 seconds
        *
        * */

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

        // if added the number of hours spent, add the number of minutes spent on focus/break activity on focus/break activity
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

        // if not added the number of hours spent, if the user spent at least 1 minute, print the number of minutes spent on focus/break activity
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

        // if not added the number of minutes spent, add the number of seconds spent on focus/break activity
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

        // return the final string
        return output;

    }


    /* Converts the number of seconds contained in (timer>tempo) into the "MM:SS" format */
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

    }

}
