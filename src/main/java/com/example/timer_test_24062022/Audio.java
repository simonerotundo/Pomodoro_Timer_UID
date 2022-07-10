package com.example.timer_test_24062022;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class Audio {

    private static Audio instance = null;
    public static Audio getInstance(){

        if (instance==null)
            instance = new Audio();

        return instance;

    }



    // da dividere in NOME_PATH e NOME_NOME
    final String DEFAULT = "src/main/resources/Sounds/bell-default.wav";
    final String BELL = "src/main/resources/Sounds/small-bell-ringing-short-sound-effect.mp3";
    final String BIRD = "src/main/resources/Sounds/small-bird-chirp-sound-effect.mp3";
    final String DIGITAL = "src/main/resources/Sounds/warning-beeping-sound.mp3";


    private String audioPathArray[]  = {  DEFAULT, BELL, BIRD, DIGITAL };
    private String audioTitleArray[] = LanguageHandler.getInstance().getAudioArrayString();
    public String getAudioTitleByID(int index) {

        switch(index) {

            case 0:
                return audioTitleArray[0];
            case 1:
                return audioTitleArray[1];
            case 2:
                return audioTitleArray[2];
            case 3:
                return audioTitleArray[3];

        }

        return "?";

    }

    // DEFAULT AUDIO EFFECT
    String path = DEFAULT;
    Media media = new Media(new File(path).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(media);


    public void setAudio(int id) {

        this.media = new Media(new File(audioPathArray[id]).toURI().toString());
        this.mediaPlayer = new MediaPlayer(media);

    }
    public void playAudio() {
        mediaPlayer.play();
        mediaPlayer.setOnEndOfMedia(stopAudio);
    }
    Runnable stopAudio = new Runnable() {
        @Override
        public void run() {
            mediaPlayer.stop();
        }
    };


}
