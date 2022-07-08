package com.example.timer_test_24062022;

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
        ControllerHandler.getInstance().startButtonTextProperty().addListener( observable -> startButton.setText(ControllerHandler.getInstance().getStartButtonText()) );
        ControllerHandler.getInstance().numberOfPomodorosProperty().addListener( observable -> pomodoroLabel.setText("#" + ControllerHandler.getInstance().getNumberOfPomodoros()) );


        /* preferences */
        boolean audioEnableDefault = true;
        boolean autoRunDefault = false;

        audioEnableCheckbox.setSelected(audioEnableDefault);
        autoRunPomodoro.setSelected(autoRunDefault);
        autoRunBreaks.setSelected(autoRunDefault);

        ControllerHandler.getInstance().setAutoRunPomodoro(autoRunDefault);
        ControllerHandler.getInstance().setAutoRunBreaks(autoRunDefault);




        // COLORI DINAMICI
        ActivityHandler.getInstance().currentActivityProperty().addListener( observable -> {
            if(ActivityHandler.getInstance().getCurrentActivity() == 1)      {

                activityTextLabel.setText("Time to Focus!");

                baseAnchorPane.setStyle("-fx-background-color: #d95550; ");
                mainAnchorPane.setStyle("-fx-background-color: #dd6662;");
                startButton.setStyle("-fx-text-fill:           #d95550;");

                focusSwitchButton.setStyle("-fx-background-color: #000000; -fx-opacity: 0.6; -fx-font-weight: bold;");
                shortBreakSwitchButton.setStyle("-fx-background-color: transparent;");
                longBreakSwitchButton.setStyle("-fx-background-color: transparent;");

                preferencesButton.setStyle("-fx-background-color: #dd6662;");
                preferencesVbox.setStyle("-fx-background-color: #dd6662;");


            }
            else if(ActivityHandler.getInstance().getCurrentActivity() == 2) {

                activityTextLabel.setText("Time for a Break!");

                baseAnchorPane.setStyle("-fx-background-color: #4c9195;");
                mainAnchorPane.setStyle("-fx-background-color:  #5e9ca0");
                startButton.setStyle("-fx-text-fill:           #4c9195;");

                focusSwitchButton.setStyle("-fx-background-color: transparent;");
                shortBreakSwitchButton.setStyle("-fx-background-color: #000000; -fx-opacity: 0.6; -fx-font-weight: bold;");
                longBreakSwitchButton.setStyle("-fx-background-color: transparent;");

                preferencesButton.setStyle("-fx-background-color: #5e9ca0;");
                preferencesVbox.setStyle("-fx-background-color: #5e9ca0;");

            }
            else if(ActivityHandler.getInstance().getCurrentActivity() == 3) {

                activityTextLabel.setText("Time for a Break!");

                baseAnchorPane.setStyle("-fx-background-color: #457ca3;");
                mainAnchorPane.setStyle("-fx-background-color:  #5889ac");
                startButton.setStyle("-fx-text-fill:           #457ca3;");

                focusSwitchButton.setStyle("-fx-background-color: transparent;");
                shortBreakSwitchButton.setStyle("-fx-background-color: transparent;");
                longBreakSwitchButton.setStyle("-fx-background-color: #000000; -fx-opacity: 0.6; -fx-font-weight: bold;");

                preferencesButton.setStyle("-fx-background-color: #5889ac;");
                preferencesVbox.setStyle("-fx-background-color: #5889ac;");

            }
        } );


        // default activity
        Activity.getInstance().onFocusActivity();

        // preferences test
        preferencesVbox.setVisible(false);



        // TEST
        ControllerHandler.getInstance().selectedAudioEffectProperty().addListener( observable -> {

            audioEffectSelector.setText(Audio.getInstance().audioTitleArray[ControllerHandler.getInstance().getSelectedAudioEffect()]);
            Audio.getInstance().setAudio(ControllerHandler.getInstance().getSelectedAudioEffect());

        });
        audioEffectSelector.setText("Default");

    }





    /* --- GRAPHIC ELEMENTS --- */

    @FXML private AnchorPane baseAnchorPane;
    @FXML private AnchorPane mainAnchorPane;

    @FXML private Button focusSwitchButton;
    @FXML private Button shortBreakSwitchButton;
    @FXML private Button longBreakSwitchButton;

    @FXML private Label timerLabel;
    @FXML private Button startButton;
    @FXML private Label pomodoroLabel;
    @FXML private Label activityTextLabel;
    @FXML private CheckBox audioEnableCheckbox;
    @FXML private CheckBox autoRunPomodoro;
    @FXML private CheckBox autoRunBreaks;

    @FXML private VBox preferencesVbox;
    @FXML private Button preferencesButton;
    @FXML private MenuButton audioEffectSelector;



    /* --- METHODS --- */

    // click on activity buttons
    @FXML private void focusSwitchButtonOnClick()      {
        Activity.getInstance().onFocusActivity();
    }
    @FXML private void shortBreakSwitchButtonOnClick() {
        Activity.getInstance().onShortBreakActivity();
    }
    @FXML private void longBreakSwitchButtonOnClick()  {
        Activity.getInstance().onLongBreakActivity();
    }

    // start button click
    @FXML private void startTimerButtonOnClick() {
        ControllerHandler.getInstance().onStartTimerButton();
    }

    // audio effects checkbox
    @FXML private void audioEnableCheckboxOnClick() {
        ControllerHandler.getInstance().onAudioEnableCheckbox(audioEnableCheckbox.isSelected()); }

    // auto run activity
    @FXML private void autoRunPomodoroOnClick() {
        ControllerHandler.getInstance().onAutoRunPomodoro(autoRunPomodoro.isSelected());
    }
    @FXML private void autoRunBreaksOnClick() {
        ControllerHandler.getInstance().onAutoRunBreaks(autoRunBreaks.isSelected());
    }





    @FXML void showPreferences() {

        // controlla che le altre activity non siano visibili!
        if(preferencesVbox.isVisible()) { preferencesVbox.setVisible(false); SceneHandler.getInstance().getStage().setHeight(552); }
        else { preferencesVbox.setVisible(true); SceneHandler.getInstance().getStage().setHeight(800); }

    }
    @FXML void setDefaultAudio() {
        ControllerHandler.getInstance().setSelectedAudioEffect(0);
    } // DEFAULT - BELL
    @FXML void setCustomAudio1() { ControllerHandler.getInstance().setSelectedAudioEffect(1); } // BELL
    @FXML void setCustomAudio2() { ControllerHandler.getInstance().setSelectedAudioEffect(2); } // BIRD
    @FXML void setCustomAudio3() { ControllerHandler.getInstance().setSelectedAudioEffect(3); } // DIGITAL


}
