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
    final int POMODORO_ID = 0;
    final int SHORT_BREAK_ID = 1;
    final int LONG_BREAK_ID = 2;
    final String NEXT_ACTIVITY = "Starting ";
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
    public String getAudioString() {

        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {

            return ItalianDictionary.getInstance().AUDIO;

        }

        return EnglishDictionary.getInstance().AUDIO;

    }
    public String getSetAudioString() {

        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {

            return ItalianDictionary.getInstance().SET_AUDIO;

        }

        return EnglishDictionary.getInstance().SET_AUDIO;

    }
    public String[] getAudioArrayString() {

        String[] audioTitles = new String[4];

        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {

            audioTitles[0] = ItalianDictionary.getInstance().DEFAULT_STRING;
            audioTitles[1] = ItalianDictionary.getInstance().BELL_STRING;
            audioTitles[2] = ItalianDictionary.getInstance().BIRD_STRING;
            audioTitles[3] = ItalianDictionary.getInstance().DIGITAL_STRING;

        }
        else {

            audioTitles[0] = EnglishDictionary.getInstance().DEFAULT_STRING;
            audioTitles[1] = EnglishDictionary.getInstance().BELL_STRING;
            audioTitles[2] = EnglishDictionary.getInstance().BIRD_STRING;
            audioTitles[3] = EnglishDictionary.getInstance().DIGITAL_STRING;

        }

        return audioTitles;

    }
    public String getAudioStringByID(int id) {
        String[] titles = getAudioArrayString();
        return titles[id];
    }
    public String getAudioTitleTranslation() { // TODO: 11/07/2022
        return LanguageHandler.getInstance().getAudioStringByID(ControllerHandler.getInstance().getSelectedAudioEffect());
    }
    public String getAutoRunPomodoroString() {

        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {
            return ItalianDictionary.getInstance().AUTORUN_POMODORO;
        }

        return EnglishDictionary.getInstance().AUTORUN_POMODORO;

    }
    public String getAutoRunBreaksString() {

        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {
            return ItalianDictionary.getInstance().AUTORUN_BREAKS;
        }

        return EnglishDictionary.getInstance().AUTORUN_BREAKS;

    }
    public String getFunctionalString() {

        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {
            return ItalianDictionary.getInstance().FUNCTIONALS;
        }

        return EnglishDictionary.getInstance().FUNCTIONALS;

    }
    public String getLanguageString() {

        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {
            return ItalianDictionary.getInstance().LANGUAGE;
        }

        return EnglishDictionary.getInstance().LANGUAGE;

    }




    /* report */
    public String getReportString() {

        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {
            return ItalianDictionary.getInstance().REPORT;
        }

        return EnglishDictionary.getInstance().REPORT;

    }
    public String getFocusAndBreakTimeString() {

        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {
            return ItalianDictionary.getInstance().REPORT_SECTION_TITLE;
        }

        return EnglishDictionary.getInstance().REPORT_SECTION_TITLE;

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
    public String getTimeUnitsString(int seconds) { // TODO: 10/07/2022 se il tempo è superiore ad un minuto, mi restituisce il tempo in minuti (da fare anche con le ore)
        return "";        
    }
    public String getSecondsString(int seconds) {

        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {

            if(seconds == 1) { return ItalianDictionary.getInstance().SECOND; }
            return ItalianDictionary.getInstance().SECONDS;
        }

        if(seconds == 1) { return EnglishDictionary.getInstance().SECOND; }
        return EnglishDictionary.getInstance().SECONDS;

    }




    /* alert */
    public String getAlertConfirmationString() {

        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {
            return ItalianDictionary.getInstance().ASK_FOR_CONFIRM;
        }

        return EnglishDictionary.getInstance().ASK_FOR_CONFIRM;

    }
    public String getConfirmationString() {

        if(getPreferredLanguage() == ItalianDictionary.getInstance().LANGUAGE_ID) {
            return ItalianDictionary.getInstance().CONFIRMATION;
        }

        return EnglishDictionary.getInstance().CONFIRMATION;

    }










}
