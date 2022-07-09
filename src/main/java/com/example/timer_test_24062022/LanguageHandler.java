package com.example.timer_test_24062022;

import javafx.beans.property.SimpleStringProperty;

public class LanguageHandler {

    private static LanguageHandler instance = null;
    public static LanguageHandler getInstance(){
        if (instance==null)
            instance = new LanguageHandler();
        return instance;

    }


    /* Language Picker */
    SimpleStringProperty preferredLanguage = new SimpleStringProperty(EnglishDictionary.getInstance().LANGUAGE_ID);
    public SimpleStringProperty preferredLanguageProperty() {
        return preferredLanguage;
    }
    public String getPreferredLanguage() {
        return preferredLanguage.get();
    }
    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage.set(preferredLanguage);
    }


    /* application title */
    final String APPLICATION_TITLE = "Pomodoro Timer";

    /* Language not found */
    final String LANGUAGE_ERROR = "LANGUAGE ERROR";

    /* Empty String */
    final String EMPTY_STRING = "";

    /* Debug */
    final String NEXT_ACTIVITY = "Next activity: ";
    final String ACTIVITY_NAMES[] = { "Pomodoro", "Short Break", "Long Break" };



    /* zona activities */
    public String getPomodoroString() {

        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {
            return ItalianDictionary.getInstance().POMODORO;
        }

        return EnglishDictionary.getInstance().POMODORO;

    }
    public String getShortBreakString() {

        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {
            return ItalianDictionary.getInstance().SHORT_BREAK;
        }

        return EnglishDictionary.getInstance().SHORT_BREAK;

    }
    public String getLongBreakString() {

        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {
            return ItalianDictionary.getInstance().LONG_BREAK;
        }

        return EnglishDictionary.getInstance().LONG_BREAK;

    }

    /* start/pause button */
    public String getPlayPauseString(String currentString) {

        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {

            // se è START in inglese, restituisco START in italiano
            if(currentString.compareTo(EnglishDictionary.getInstance().START) == 0 ) {
                return ItalianDictionary.getInstance().START;
            }
            return ItalianDictionary.getInstance().PAUSE;

        }

        if(currentString == ItalianDictionary.getInstance().START) {
            return EnglishDictionary.getInstance().START;
        }
        return EnglishDictionary.getInstance().PAUSE;

    }
    public String getStartTimerString() {

        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {
            return ItalianDictionary.getInstance().START;
        }

        return EnglishDictionary.getInstance().START;

    }
    public String getPauseTimerString() {

        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {
            return ItalianDictionary.getInstance().PAUSE;
        }

        return EnglishDictionary.getInstance().PAUSE;

    }

    /* zona counter dei pomodori */
    public String getTimeToFocusString() {

        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {
            return ItalianDictionary.getInstance().TIME_TO_FOCUS;
        }

        return EnglishDictionary.getInstance().TIME_TO_FOCUS;

    }
    public String getTimeToBreakString() {

        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {
            return ItalianDictionary.getInstance().TIME_TO_BREAK;
        }

        return EnglishDictionary.getInstance().TIME_TO_BREAK;

    }

    /* preferences */
    public String getPreferenceString() {

        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {
            return ItalianDictionary.getInstance().PREFERENCES;
        }

        return EnglishDictionary.getInstance().PREFERENCES;

    }
    // TODO: 09/07/2022 - ne mancano la metà lol

    /* report */
    public String getReportString() {

        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {
            return ItalianDictionary.getInstance().REPORT;
        }

        return EnglishDictionary.getInstance().REPORT;

    }
    public String getYouHaveFocusedForString() {
        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {
            return ItalianDictionary.getInstance().YOU_HAVE_FOCUSED_FOR;
        }

        return EnglishDictionary.getInstance().YOU_HAVE_FOCUSED_FOR;

    }
    public String getYouHaveRelaxedForString() {
        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {
            return ItalianDictionary.getInstance().YOU_HAVE_RELAXED_FOR;
        }

        return EnglishDictionary.getInstance().YOU_HAVE_RELAXED_FOR;

    }


    /* default string */
    public String getDefaultString() {

        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {
            return ItalianDictionary.getInstance().DEFAULT_STRING;
        }

        return EnglishDictionary.getInstance().DEFAULT_STRING;

    }

    /* measurement units */
    public String getSecondString() {

        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {
            return ItalianDictionary.getInstance().SECOND;
        }

        return EnglishDictionary.getInstance().SECOND;

    }
    public String getSecondsString() {

        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {
            return ItalianDictionary.getInstance().SECONDS;
        }

        return EnglishDictionary.getInstance().SECONDS;

    }

    public String getMinuteString() {

        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {
            return ItalianDictionary.getInstance().MINUTE;
        }

        return EnglishDictionary.getInstance().MINUTE;

    }
    public String getMiinutesString() {

        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {
            return ItalianDictionary.getInstance().MINUTES;
        }

        return EnglishDictionary.getInstance().MINUTES;

    }

    public String getHourString() {

        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {
            return ItalianDictionary.getInstance().HOUR;
        }

        return EnglishDictionary.getInstance().HOUR;

    }
    public String getHoursString() {

        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {
            return ItalianDictionary.getInstance().HOURS;
        }

        return EnglishDictionary.getInstance().HOURS;

    }


    /* alert */
    public String getAlertConfirmationString() {

        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {
            return ItalianDictionary.getInstance().ASK_FOR_CONFIRM;
        }

        return EnglishDictionary.getInstance().ASK_FOR_CONFIRM;

    }










}
