package com.example.timer_test_24062022;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneHandler {

    private static SceneHandler instance = null;
    public static SceneHandler getInstance(){
        if (instance==null)
            instance = new SceneHandler();
        return instance;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Stage stage;
    public Scene scene;


    public void init(Stage stage) throws IOException {
        this.stage=stage;


        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("home.fxml"));
        scene = new Scene(fxmlLoader.load(), 492, 552);
        stage.setMinWidth(492); stage.setMinHeight(552);
        stage.setMaxWidth(740); stage.setMaxHeight(800);
        stage.setResizable(true);
        scene.getStylesheets().add("/style.css");

        // TODO: 04/07/2022 - QUANDO PREMO LA BARRA SPAZIATRICE, DEVE SIMULARE UN CLICK SU STARTBUTTON
        scene.setOnKeyPressed( e -> ControllerHandler.getInstance().shortcuts(e) );

        stage.setTitle("Pomodoro Timer");
        stage.setScene(scene);
        stage.show();

    }

}
