package com.example.timer_test_24062022;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ControllerHandler {

    /* --- SINGLETON --- */
    private static ControllerHandler instance = null;
    public static ControllerHandler getInstance(){
        if (instance==null)
            instance = new ControllerHandler();
        return instance;
    }





    /* --- BACKGROUND --- */

    // Number of Pomodoros
    private SimpleIntegerProperty numberOfPomodoros = new SimpleIntegerProperty(0);
    public SimpleIntegerProperty numberOfPomodorosProperty() {
        return numberOfPomodoros;
    }
    public int getNumberOfPomodoros() {
        return numberOfPomodoros.get();
    }
    public void incrementNumberOfPomodoros() {
        numberOfPomodoros.set( numberOfPomodoros.get()+1 );
    }


    // Timer status
    private SimpleBooleanProperty timerAlreadyStarted = new SimpleBooleanProperty(false);
    public SimpleBooleanProperty timerAlreadyStartedProperty() {
        return timerAlreadyStarted;
    }
    public boolean getTimerAlreadyStarted() {
        return timerAlreadyStarted.get();
    }
    public void setTimerAlreadyStarted(boolean timerAlreadyStarted) {
        this.timerAlreadyStarted.set(timerAlreadyStarted);
    }





    /* --- GRAPHIC ELEMENTS --- */

    // Timer Label text
    private SimpleStringProperty timerLabelText = new SimpleStringProperty("");
    public SimpleStringProperty timerLabelTextProperty() {
        return timerLabelText;
    }
    public String getTimerLabelText() {
        return timerLabelText.get();
    }
    public void setTimerLabelText(String timerLabelText) {
        this.timerLabelText.set(timerLabelText);
    }
    public void updateTimerLabelText() {
        setTimerLabelText(Time.getInstance().secondsToMinutesAndSeconds());
    }


    // Start Timer Button
    private SimpleStringProperty startButtonText = new SimpleStringProperty("");
    public SimpleStringProperty startButtonTextProperty() {
        return startButtonText;
    }
    public String getStartButtonText() {
        return startButtonText.get();
    }
    public void setStartButtonText(String startButtonText) {
        this.startButtonText.set(startButtonText);
    }
    public void updateStartButtonTextToStart() {
        setStartButtonText("START");
    }
    public void updateStartButtonTextToPause() {
        setStartButtonText("PAUSE");
    }
    public void onStartTimerButton() {

        // SE IL TIMER È IN PAUSA
        if(!getTimerAlreadyStarted()) {

            // aggiungo un listener al tempo
            Timer.getInstance().tempoProperty().addListener( observable -> updateTimerLabelText() );

            Timer.getInstance().startTimer();   // avvio il timer
            setTimerAlreadyStarted(true);       // imposto che il timer è stato avviato
            updateStartButtonTextToPause();     // imposto il testo del pulsante in "PAUSE" - ERRORE

        }

        // SE IL TIMER È GIÀ STATO AVVIATO
        else {

            Timer.getInstance().pauseTimer();   // interrompo il timer
            setTimerAlreadyStarted(false);      // imposto che il timer è stato interrotto
            updateStartButtonTextToStart();     // imposto il testo del pulsante in "START"

        }

    }





    /* --- USER PREFERENCES --- */

    // Audio Enabler Checkbox
    private SimpleBooleanProperty enableAudio = new SimpleBooleanProperty(true);    // true perchè di default la checkbox è tickata
    public SimpleBooleanProperty enableAudioProperty() {
        return enableAudio;
    }
    public boolean getEnableAudio() {
        return enableAudio.get();
    }
    public void setEnableAudio(boolean enableAudio) {
        this.enableAudio.set(enableAudio);
    }
    public void onAudioEnableCheckbox(boolean audioPreferences) { setEnableAudio(audioPreferences); }


    // Autorun Pomodoro
    private SimpleBooleanProperty autoRunPomodoro = new SimpleBooleanProperty(false);
    public SimpleBooleanProperty autoRunPomodoroProperty() {
        return autoRunPomodoro;
    }
    public boolean getAutoRunPomodoro() {
        return autoRunPomodoro.get();
    }
    public void setAutoRunPomodoro(boolean autoRunPomodoro) {
        this.autoRunPomodoro.set(autoRunPomodoro);
    }
    public void onAutoRunPomodoro(boolean autorunPreferences) {
        setAutoRunPomodoro(autorunPreferences);
    }


    // Autorun Breaks
    private SimpleBooleanProperty autoRunBreaks = new SimpleBooleanProperty(false);
    public SimpleBooleanProperty autoRunBreaksProperty() {
        return autoRunBreaks;
    }
    public boolean getAutoRunBreaks() {
        return autoRunBreaks.get();
    }
    public void setAutoRunBreaks(boolean autoRunBreaks) {
        this.autoRunBreaks.set(autoRunBreaks);
    }
    public void onAutoRunBreaks(boolean autorunPreferences) {
        setAutoRunBreaks(autorunPreferences);
    }




    private SimpleIntegerProperty selectedAudioEffect = new SimpleIntegerProperty(0);
    public SimpleIntegerProperty selectedAudioEffectProperty() {
        return selectedAudioEffect;
    }
    public int getSelectedAudioEffect() {
        return selectedAudioEffect.get();
    }
    public void setSelectedAudioEffect(int audioEffect) {
        this.selectedAudioEffect.set(audioEffect);
    }



    /* --- SHORTCUTS --- */

    // Play, Pause, Activity
    public void shortcuts(KeyEvent pressed) {

        // DIGITS
        if(pressed.getCode().isDigitKey()) {

            // ACTIVITIES: 1->POMODORO, 2->SHORTBREAK, 3->LONGBREAK
            if      (pressed.getCode() == KeyCode.DIGIT1) {
                Activity.getInstance().onFocusActivity();
            }
            else if (pressed.getCode() == KeyCode.DIGIT2) {
                Activity.getInstance().onShortBreakActivity();
            }
            else if (pressed.getCode() == KeyCode.DIGIT3) {
                Activity.getInstance().onLongBreakActivity();
            }

        }

        // LETTERS
        else if(pressed.getCode().isLetterKey()) {

            // PLAY/PAUSE ACTIVITY
            if(pressed.getCode() == KeyCode.P) {
                onStartTimerButton();
            }

        }

    }

}
