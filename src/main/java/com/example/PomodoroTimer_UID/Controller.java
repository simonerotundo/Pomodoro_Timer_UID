package com.example.PomodoroTimer_UID;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // UI Elements
        ControllerHandler.getInstance().timerLabelTextProperty().addListener( observable -> timerLabel.setText(ControllerHandler.getInstance().getTimerLabelText()) );
        ControllerHandler.getInstance().startButtonTextProperty().addListener( observable -> startPauseButton.setText(ControllerHandler.getInstance().getStartButtonText()) );
        ControllerHandler.getInstance().numberOfPomodorosProperty().addListener( observable -> pomodoroLabel.setText("#" + ControllerHandler.getInstance().getNumberOfPomodoros()) );


        /* Set the default preferences */
        boolean audioEnableDefault = true;
        audioEnableCheckbox.setSelected(audioEnableDefault);

        boolean autoRunDefault = false;
        ControllerHandler.getInstance().setAutoRunPomodoro(autoRunDefault);
        ControllerHandler.getInstance().setAutoRunBreaks(autoRunDefault);


        /* Set listener in order to dynamically switch colors and texts */
        ActivityHandler.getInstance().currentActivityProperty().addListener( observable -> {

            // If Pomodoro is selected ..
            if(ActivityHandler.getInstance().getCurrentActivity() == 1)      {

                activityTextLabel.setText(LanguageHandler.getInstance().getTimeToFocusString());    // .. text will switch to something like "Time to focus!"

                /* Style the main UI Elements */
                baseAnchorPane.setStyle("-fx-background-color: #d95550; ");
                mainAnchorPane.setStyle("-fx-background-color: #dd6662;");
                startPauseButton.setStyle("-fx-text-fill:      #d95550;");

                focusSwitchButton.setStyle("-fx-background-color: #000000; -fx-opacity: 0.6; -fx-font-weight: bold;");
                shortBreakSwitchButton.setStyle("-fx-background-color: transparent;");
                longBreakSwitchButton.setStyle("-fx-background-color: transparent;");

                preferencesButton.setStyle("-fx-background-color: #dd6662;");
                preferencesVbox.setStyle("-fx-background-color: #dd6662;");

                reportButton.setStyle("-fx-background-color: #dd6662;");
                reportVbox.setStyle("-fx-background-color: #dd6662;");


            }

            // If not (Short Break or Long Break is selected) ..
            else {

                activityTextLabel.setText(LanguageHandler.getInstance().getTimeToBreakString());    // .. text will switch to something like "Time for a Break!"

                // If Short Break is selected ..
                if(ActivityHandler.getInstance().getCurrentActivity() == 2) {

                    /* Style the main UI Elements */
                    baseAnchorPane.setStyle("-fx-background-color: #4c9195;");
                    mainAnchorPane.setStyle("-fx-background-color:  #5e9ca0");
                    startPauseButton.setStyle("-fx-text-fill:           #4c9195;");

                    focusSwitchButton.setStyle("-fx-background-color: transparent;");
                    shortBreakSwitchButton.setStyle("-fx-background-color: #000000; -fx-opacity: 0.6; -fx-font-weight: bold;");
                    longBreakSwitchButton.setStyle("-fx-background-color: transparent;");

                    preferencesButton.setStyle("-fx-background-color: #5e9ca0;");
                    preferencesVbox.setStyle("-fx-background-color: #5e9ca0;");

                    reportButton.setStyle("-fx-background-color: #5e9ca0;");
                    reportVbox.setStyle("-fx-background-color: #5e9ca0;");

                }

                // If Long Break is selected ..
                else if(ActivityHandler.getInstance().getCurrentActivity() == 3) {

                    /* Style the main UI Elements */
                    baseAnchorPane.setStyle("-fx-background-color: #457ca3;");
                    mainAnchorPane.setStyle("-fx-background-color:  #5889ac");
                    startPauseButton.setStyle("-fx-text-fill:           #457ca3;");

                    focusSwitchButton.setStyle("-fx-background-color: transparent;");
                    shortBreakSwitchButton.setStyle("-fx-background-color: transparent;");
                    longBreakSwitchButton.setStyle("-fx-background-color: #000000; -fx-opacity: 0.6; -fx-font-weight: bold;");

                    preferencesButton.setStyle("-fx-background-color: #5889ac;");
                    preferencesVbox.setStyle("-fx-background-color: #5889ac;");

                    reportButton.setStyle("-fx-background-color: #5889ac;");
                    reportVbox.setStyle("-fx-background-color: #5889ac;");

                }

            }

        });


        /* Set Pomodoro as the default activity */
        Activity.getInstance().onFocusActivity();


        /* Hide "Preferences" and "Report" menus by default */
        preferencesVbox.setVisible(false);
        reportVbox.setVisible(false);


        /* Set listener in order to manage the change of the audio effect  */
        ControllerHandler.getInstance().selectedAudioEffectProperty().addListener( observable -> {

            audioEffectSelector.setText(Audio.getInstance().getAudioTitleByID(ControllerHandler.getInstance().getSelectedAudioEffect()));   // set the title of the selected audio effect in the MenuButton element
            Audio.getInstance().setAudio(ControllerHandler.getInstance().getSelectedAudioEffect());                                         // set selected audio effect

        });
        audioEffectSelector.setText(LanguageHandler.getInstance().getDefaultString());  // set the selected audio effect label with the default audio effect title


        /* Set the focus time label located in the report menu */
        reportFocusTime.setText(LanguageHandler.getInstance().getYouHaveFocusedForString() + Time.getInstance().secondsToHoursMinutesSeconds(Timer.getInstance().getTempoConcentrazione()) + ".");
        Timer.getInstance().tempoConcentrazioneProperty().addListener( observable ->
                reportFocusTime.setText(LanguageHandler.getInstance().getYouHaveFocusedForString() + Time.getInstance().secondsToHoursMinutesSeconds(Timer.getInstance().getTempoConcentrazione()) + ".") );

        /* Set the break time label located in the report menu */
        reportBreakTime.setText(LanguageHandler.getInstance().getYouHaveRelaxedForString() + Time.getInstance().secondsToHoursMinutesSeconds(Timer.getInstance().getTempoPausa())  + ".");
        Timer.getInstance().tempoPausaProperty().addListener( observable ->
                reportBreakTime.setText(LanguageHandler.getInstance().getYouHaveRelaxedForString() + Time.getInstance().secondsToHoursMinutesSeconds(Timer.getInstance().getTempoPausa())  + ".") );



        /* English to Italian translation and vice versa */
        LanguageHandler.getInstance().preferredLanguageProperty().addListener( observable -> {

            /* activity buttons */
            focusSwitchButton.setText(LanguageHandler.getInstance().getPomodoroString());
            shortBreakSwitchButton.setText(LanguageHandler.getInstance().getShortBreakString());
            longBreakSwitchButton.setText(LanguageHandler.getInstance().getLongBreakString());

            /* start/pause button */
            startPauseButton.setText(LanguageHandler.getInstance().getPlayPauseString(startPauseButton.getText()));

            /* time to focus/break label */
            if(ActivityHandler.getInstance().itIsAPomodoro()) { activityTextLabel.setText(LanguageHandler.getInstance().getTimeToFocusString()); }
            else if(ActivityHandler.getInstance().itIsBreak()) { LanguageHandler.getInstance().getTimeToBreakString(); }

            /* preferences menu */
            preferencesButton.setText(LanguageHandler.getInstance().getPreferenceString());
            audioEnableCheckbox.setText(LanguageHandler.getInstance().getAudioString());
            setAudioMenuLabel.setText(LanguageHandler.getInstance().getSetAudioString() + ": ");
            functionalMenuCategoryLabel.setText(LanguageHandler.getInstance().getFunctionalString());
            autoRunPomodoro.setText(LanguageHandler.getInstance().getAutoRunPomodoroString());
            autoRunBreaks.setText(LanguageHandler.getInstance().getAutoRunBreaksString());
            languageMenuCategoryLabel.setText(LanguageHandler.getInstance().getLanguageString());
            audioEffectSelector.setText(LanguageHandler.getInstance().getAudioStringByID(ControllerHandler.getInstance().getSelectedAudioEffect()));
            defaultAudioMenuItem.setText(LanguageHandler.getInstance().getAudioStringByID(0));
            bellAudioMenuItem.setText(LanguageHandler.getInstance().getAudioStringByID(1));
            birdAudioMenuItem.setText(LanguageHandler.getInstance().getAudioStringByID(2));
            digitalAudioMenuItem.setText(LanguageHandler.getInstance().getAudioStringByID(3));

            /* report menu */
            reportButton.setText(LanguageHandler.getInstance().getReportString());
            focusAndBreakTimeMenuCategoryLabel.setText(LanguageHandler.getInstance().getFocusAndBreakTimeString());
            reportFocusTime.setText(LanguageHandler.getInstance().getYouHaveFocusedForString() + Time.getInstance().secondsToHoursMinutesSeconds(Timer.getInstance().getTempoConcentrazione()) + ".");
            reportBreakTime.setText(LanguageHandler.getInstance().getYouHaveRelaxedForString() + Time.getInstance().secondsToHoursMinutesSeconds(Timer.getInstance().getTempoPausa()) + ".");

        } );

    }



    /* --- UI ELEMENTS --- */

    // Main containers
    @FXML private AnchorPane baseAnchorPane;
    @FXML private AnchorPane mainAnchorPane;

    // Activities, timer and main button
    @FXML private Button focusSwitchButton;
    @FXML private Button shortBreakSwitchButton;
    @FXML private Button longBreakSwitchButton;
    @FXML private Label timerLabel;
    @FXML private Button startPauseButton;

    // Number of pomodoros, focus or break
    @FXML private Label pomodoroLabel;
    @FXML private Label activityTextLabel;

    // Preferences
    @FXML private VBox preferencesVbox;
    @FXML private Button preferencesButton;
    @FXML private Label functionalMenuCategoryLabel;
    @FXML private CheckBox audioEnableCheckbox;
    @FXML private MenuButton audioEffectSelector;
    @FXML private Label setAudioMenuLabel;
    @FXML private MenuItem defaultAudioMenuItem;
    @FXML private MenuItem bellAudioMenuItem;
    @FXML private MenuItem birdAudioMenuItem;
    @FXML private MenuItem digitalAudioMenuItem;
    @FXML private CheckBox autoRunPomodoro;
    @FXML private CheckBox autoRunBreaks;
    @FXML private Label languageMenuCategoryLabel;

    // Reports
    @FXML private VBox reportVbox;
    @FXML private Button reportButton;
    @FXML private Label focusAndBreakTimeMenuCategoryLabel;
    @FXML private Label reportFocusTime;
    @FXML private Label reportBreakTime;



    /* --- METHODS --- */

    /* Focus, Short Break or Long Break activity buttons on click */
    @FXML private void focusSwitchButtonOnClick() {
        Activity.getInstance().onFocusActivity();   // run Pomodoro activity
    }
    @FXML private void shortBreakSwitchButtonOnClick() {
        Activity.getInstance().onShortBreakActivity();  // run Short Break activity
    }
    @FXML private void longBreakSwitchButtonOnClick() {
        Activity.getInstance().onLongBreakActivity();   // run Long Break activity
    }


    /* Start timer button on click */
    @FXML private void startTimerButtonOnClick() {
        ControllerHandler.getInstance().onStartTimerButton();
    }


    /* Enable audio preference */
    @FXML private void audioEnableCheckboxOnClick() {
        ControllerHandler.getInstance().onAudioEnableCheckbox(audioEnableCheckbox.isSelected()); }

    /* Audio effect on click (inside the MenuButton) */
    @FXML private void setDefaultAudio() {
        ControllerHandler.getInstance().setSelectedAudioEffect(0);                          // set selected audio effect
        audioEffectSelector.setText(LanguageHandler.getInstance().getAudioStringByID(0));   // translate the title of the audio effect in the selected language
    } // DEFAULT
    @FXML private void setCustomAudio1() {
        ControllerHandler.getInstance().setSelectedAudioEffect(1);
        audioEffectSelector.setText(LanguageHandler.getInstance().getAudioStringByID(1));
    } // BELL
    @FXML private void setCustomAudio2() {
        ControllerHandler.getInstance().setSelectedAudioEffect(2);
        audioEffectSelector.setText(LanguageHandler.getInstance().getAudioStringByID(2));
    } // BIRD
    @FXML private void setCustomAudio3() {
        ControllerHandler.getInstance().setSelectedAudioEffect(3);
        audioEffectSelector.setText(LanguageHandler.getInstance().getAudioStringByID(3));
    } // DIGITAL


    /* Autorun Pomodoro and Break activities CheckBox on click */
    @FXML private void autoRunPomodoroOnClick() {
        ControllerHandler.getInstance().onAutoRunPomodoro(autoRunPomodoro.isSelected());
    }
    @FXML private void autoRunBreaksOnClick() {
        ControllerHandler.getInstance().onAutoRunBreaks(autoRunBreaks.isSelected());
    }


    /* Extend and Style the Preferences or Report menus */
    @FXML void showPreferences() {

        // PREFERENCES:OFF, REPORT:OFF -> set Style and show the preferences menu
        if(!preferencesVbox.isVisible() && !reportVbox.isVisible()) {

            // COLORS
            if(ActivityHandler.getInstance().getCurrentActivity() == 1) {

                preferencesButton.setStyle("-fx-background-color: #dd6662; -fx-font-weight: bold; -fx-opacity: 1;");
                reportButton.setStyle("-fx-background-color: #dd6662; -fx-font-weight: normal; -fx-opacity: 0.6;");

            }
            else if(ActivityHandler.getInstance().getCurrentActivity() == 2) {

                preferencesButton.setStyle("-fx-background-color: #5e9ca0; -fx-font-weight: bold; -fx-opacity: 1;");
                reportButton.setStyle("-fx-background-color: #5e9ca0; -fx-font-weight: normal; -fx-opacity: 0.6;");

            }
            else {

                preferencesButton.setStyle("-fx-background-color: #5889ac; -fx-font-weight: bold; -fx-opacity: 1;");
                reportButton.setStyle("-fx-background-color: #5889ac; -fx-font-weight: normal; -fx-opacity: 0.6;");

            }

            preferencesVbox.setVisible(true);   // show preferences

            /* If the window isn't maximized, resize the window */
            if(!SceneHandler.getInstance().getStage().isMaximized()) {
                SceneHandler.getInstance().getStage().setHeight(SceneHandler.getInstance().getStage().getMaxHeight());
            }

        }

        // PREFERENCES:OFF, REPORT ON
        else if(!preferencesVbox.isVisible() && reportVbox.isVisible()) {

            if(ActivityHandler.getInstance().getCurrentActivity() == 1) {

                preferencesButton.setStyle("-fx-background-color: #dd6662; -fx-font-weight: bold; -fx-opacity: 1;");
                reportButton.setStyle("-fx-background-color: #dd6662; -fx-font-weight: normal; -fx-opacity: 0.6;");

            }
            else if(ActivityHandler.getInstance().getCurrentActivity() == 2) {

                preferencesButton.setStyle("-fx-background-color: #5e9ca0; -fx-font-weight: bold; -fx-opacity: 1;");
                reportButton.setStyle("-fx-background-color: #5e9ca0; -fx-font-weight: normal; -fx-opacity: 0.6;");

            }
            else {

                preferencesButton.setStyle("-fx-background-color: #5889ac; -fx-font-weight: bold; -fx-opacity: 1;");
                reportButton.setStyle("-fx-background-color: #5889ac; -fx-font-weight: normal; -fx-opacity: 0.6;");

            }


            reportVbox.setVisible(false);
            preferencesVbox.setVisible(true);

        }

        // PREFERENCES:ON, REPORT:OFF
        else {

            if(ActivityHandler.getInstance().getCurrentActivity() == 1) {

                preferencesButton.setStyle("-fx-background-color: #dd6662; -fx-font-weight: normal; -fx-opacity: 1;");
                reportButton.setStyle("-fx-background-color: #dd6662; -fx-font-weight: normal; -fx-opacity: 1;");

            }
            else if(ActivityHandler.getInstance().getCurrentActivity() == 2) {

                preferencesButton.setStyle("-fx-background-color: #5e9ca0; -fx-font-weight: normal; -fx-opacity: 1;");
                reportButton.setStyle("-fx-background-color: #5e9ca0; -fx-font-weight: normal; -fx-opacity: 1;");

            }
            else {

                preferencesButton.setStyle("-fx-background-color: #5889ac; -fx-font-weight: normal; -fx-opacity: 1;");
                reportButton.setStyle("-fx-background-color: #5889ac; -fx-font-weight: normal; -fx-opacity: 1;");

            }

            preferencesVbox.setVisible(false);
            if(!SceneHandler.getInstance().getStage().isMaximized()) { SceneHandler.getInstance().getStage().setHeight(SceneHandler.getInstance().getStage().getMinHeight()); }

        }

    }
    @FXML void showReport() {

        // REPORT:OFF, PREFERENCES:OFF
        if(!reportVbox.isVisible() && !preferencesVbox.isVisible()) {

            if(ActivityHandler.getInstance().getCurrentActivity() == 1) {

                preferencesButton.setStyle("-fx-background-color: #dd6662; -fx-font-weight: normal; -fx-opacity: 0.6;");
                reportButton.setStyle("-fx-background-color: #dd6662; -fx-font-weight: bold; -fx-opacity: 1;");

            }
            else if(ActivityHandler.getInstance().getCurrentActivity() == 2) {

                preferencesButton.setStyle("-fx-background-color: #5e9ca0; -fx-font-weight: normal; -fx-opacity: 0.6;");
                reportButton.setStyle("-fx-background-color: #5e9ca0; -fx-font-weight: bold; -fx-opacity: 1;");

            }
            else {

                preferencesButton.setStyle("-fx-background-color: #5889ac; -fx-font-weight: normal; -fx-opacity: 0.6;");
                reportButton.setStyle("-fx-background-color: #5889ac; -fx-font-weight: bold; -fx-opacity: 1;");

            }

            reportVbox.setVisible(true);
            if(!SceneHandler.getInstance().getStage().isMaximized()) { SceneHandler.getInstance().getStage().setHeight(SceneHandler.getInstance().getStage().getMaxHeight()); }

        }

        // REPORT:OFF, PREFERENCES ON
        else if(!reportVbox.isVisible() && preferencesVbox.isVisible()) {

            if(ActivityHandler.getInstance().getCurrentActivity() == 1) {

                preferencesButton.setStyle("-fx-background-color: #dd6662; -fx-font-weight: normal; -fx-opacity: 0.6;");
                reportButton.setStyle("-fx-background-color: #dd6662; -fx-font-weight: bold; -fx-opacity: 1;");

            }
            else if(ActivityHandler.getInstance().getCurrentActivity() == 2) {

                preferencesButton.setStyle("-fx-background-color: #5e9ca0; -fx-font-weight: normal; -fx-opacity: 0.6;");
                reportButton.setStyle("-fx-background-color: #5e9ca0; -fx-font-weight: bold; -fx-opacity: 1;");

            }
            else {

                preferencesButton.setStyle("-fx-background-color: #5889ac; -fx-font-weight: normal; -fx-opacity: 0.6;");
                reportButton.setStyle("-fx-background-color: #5889ac; -fx-font-weight: bold; -fx-opacity: 1;");

            }

            preferencesVbox.setVisible(false);
            reportVbox.setVisible(true);

        }

        // REPORT:ON, PREFERENCES:OFF
        else {

            if(ActivityHandler.getInstance().getCurrentActivity() == 1) {

                preferencesButton.setStyle("-fx-background-color: #dd6662; -fx-font-weight: normal; -fx-opacity: 1;");
                reportButton.setStyle("-fx-background-color: #dd6662; -fx-font-weight: normal; -fx-opacity: 1;");

            }
            else if(ActivityHandler.getInstance().getCurrentActivity() == 2) {

                preferencesButton.setStyle("-fx-background-color: #5e9ca0; -fx-font-weight: normal; -fx-opacity: 1;");
                reportButton.setStyle("-fx-background-color: #5e9ca0; -fx-font-weight: normal; -fx-opacity: 1;");

            }
            else {

                preferencesButton.setStyle("-fx-background-color: #5889ac; -fx-font-weight: normal; -fx-opacity: 1;");
                reportButton.setStyle("-fx-background-color: #5889ac; -fx-font-weight: normal; -fx-opacity: 1;");

            }

            reportVbox.setVisible(false);
            if(!SceneHandler.getInstance().getStage().isMaximized()) { SceneHandler.getInstance().getStage().setHeight(SceneHandler.getInstance().getStage().getMinHeight()); }
            
        }

    }


    /* Set the preferred language */
    @FXML void setPreferredLanguageEnglish() {
        LanguageHandler.getInstance().setPreferredLanguage(EnglishDictionary.getInstance().LANGUAGE_ID);    // set English as preferred language
    }
    @FXML void setPreferredLanguageItalian() {
        LanguageHandler.getInstance().setPreferredLanguage(ItalianDictionary.getInstance().LANGUAGE_ID);    // set Italian as preferred language
    }


}
