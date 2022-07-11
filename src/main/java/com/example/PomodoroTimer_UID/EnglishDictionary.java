package com.example.PomodoroTimer_UID;

public class EnglishDictionary {

    private static EnglishDictionary instance = null;
    public static EnglishDictionary getInstance(){
        if (instance==null)
            instance = new EnglishDictionary();
        return instance;

    }


    /* ID */
    final String LANGUAGE_ID = "ENGLISH";


    /* activities */
    final String POMODORO = "Pomodoro";
    final String SHORT_BREAK = "Short Break";
    final String LONG_BREAK = "Long Break";


    /* Alert */
    final String ASK_FOR_CONFIRM = "Are you sure you want to interrupt the current activity?";
    final String CONFIRMATION = "Confirmation";

    /* Buttons */
    final String START = "START";
    final String PAUSE = "PAUSE";

    /* Labels */
    final String TIME_TO_FOCUS = "Time to focus!";
    final String TIME_TO_BREAK = "Time for a break!";

    /* Preferences */
    final String PREFERENCES = "Preferences";
    final String AUDIO = "Audio";
    final String SET_AUDIO = "Set audio";
    final String FUNCTIONALS = "Autostart";
    final String AUTORUN_POMODORO = "Pomodoros";
    final String AUTORUN_BREAKS = "Breaks";
    final String LANGUAGE = "Language";



    /* Report */
    final String REPORT = "Report";
    final String REPORT_SECTION_TITLE = "Focus and Break time";
    final String YOU_HAVE_FOCUSED_FOR = "You have focused for";
    final String YOU_HAVE_RELAXED_FOR = "You have relaxed for";

    /* Measurement units */
    final String SECOND = "second";
    final String SECONDS = "seconds";

    final String MINUTE = "minute";
    final String MINUTES = "minutes";

    final String HOUR = "hour";
    final String HOURS = "hours";

    /* Default */
    final String DEFAULT_STRING = "Default";

    /* Audio */
    final String BELL_STRING = "Bell";
    final String BIRD_STRING = "Bird";
    final String DIGITAL_STRING = "Digital";

}
