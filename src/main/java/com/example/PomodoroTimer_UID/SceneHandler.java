package com.example.PomodoroTimer_UID;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneHandler {

    /* Singleton */
    private static SceneHandler instance = null;
    public static SceneHandler getInstance(){
        if (instance==null)
            instance = new SceneHandler();
        return instance;
    }

    /* inizializzo lo Stage e la Scena */
    public Stage stage;
    public Scene scene;

    public Stage getStage() {
        return stage;
    }


    /* Definisco la dimensione minima e massima dello Stage */
    private final int MIN_WIDTH = 492, MIN_HEIGHT = 552;
    private final int MAX_WIDTH = 740, MAX_HEIGHT = 880;
    private final int DEFAULT_WIDTH = MIN_WIDTH, DEFAULT_HEIGH = MIN_HEIGHT;

    public void init(Stage stage) throws IOException {

        this.stage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("home.fxml"));   // carico l'interfaccia grafica

        scene = new Scene(fxmlLoader.load(), DEFAULT_WIDTH, DEFAULT_HEIGH);                         // imposto la dimensione della scena
        stage.setTitle(LanguageHandler.getInstance().APPLICATION_TITLE);                            // imposto il titolo della finestra
        stage.setMinWidth(MIN_WIDTH); stage.setMinHeight(MIN_HEIGHT);                               // indico la dimensione minima della finestra
        stage.setMaxWidth(MAX_WIDTH); stage.setMaxHeight(MAX_HEIGHT);                               // indico la dimensione minima della finestra
        stage.setResizable(false);                                                                   // rendo lo stage ridimensionabile dall'utente

        scene.getStylesheets().add("/style.css");                                                   // importo il foglio di stile
        scene.setOnKeyPressed( ke -> ControllerHandler.getInstance().shortcuts(ke) );               // gestisco le shortcuts da tastiera
        stage.setScene(scene);                                                                      // imposto la scena
        stage.show();                                                                               // mostro la scena

    }

}
