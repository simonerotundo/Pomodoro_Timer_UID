package com.example.PomodoroTimer_UID;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class Audio {

    /* Singleton */
    private static Audio instance = null;
    public static Audio getInstance(){

        if (instance==null)
            instance = new Audio();

        return instance;

    }



    /* Audio effects path */
    final String DEFAULT = "src/main/resources/Sounds/bell-default.wav";
    final String BELL = "src/main/resources/Sounds/small-bell-ringing-short-sound-effect.mp3";
    final String BIRD = "src/main/resources/Sounds/small-bird-chirp-sound-effect.mp3";
    final String DIGITAL = "src/main/resources/Sounds/warning-beeping-sound.mp3";


    /* Initialize vectors with paths and titles of the available audio effects */
    private String audioPathArray[]  = {  DEFAULT, BELL, BIRD, DIGITAL };
    private String audioTitleArray[] = LanguageHandler.getInstance().getAudioArrayString();


    /* Set DEFAULT as default audio effect */
    String path = DEFAULT;

    /* Initialize the Media and MediaPlayer classes */
    Media media = new Media(new File(path).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(media);



    /* Set preferred audio effect */
    public void setAudio(int id) {

        this.media = new Media(new File(audioPathArray[id]).toURI().toString());    // give the path of the audio effect to the Media object
        this.mediaPlayer = new MediaPlayer(media);                                  // give the media to the MediaPlayer

    }


    /* Return the audio effect's title of the one which has the same id of the transmitted one */
    public String getAudioTitleByID(int id) {

        switch(id) {

            case 0:
                return audioTitleArray[0];  // DEFAULT

            case 1:
                return audioTitleArray[1];  // BELL

            case 2:
                return audioTitleArray[2];  // BIRD

            case 3:
                return audioTitleArray[3];  // DIGITAL

            default:
                return "?";                 // UNKNOWN AUDIO EFFECT

        }

    }


    /* Play the audio effect which is currently selected */
    public void playAudio() {
        mediaPlayer.play();                     // start playing audio
        mediaPlayer.setOnEndOfMedia(stopAudio); // when the audio ends, stop the media player
    }


    /* Stop playing audio */
    Runnable stopAudio = new Runnable() {
        @Override
        public void run() {
            mediaPlayer.stop(); // stop the media player
        }
    };


}
