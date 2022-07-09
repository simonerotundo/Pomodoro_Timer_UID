package com.example.timer_test_24062022;

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


    public Stage stage;
    public Scene scene;

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


    public void init(Stage stage) throws IOException {

        this.stage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("home.fxml"));
        scene = new Scene(fxmlLoader.load(), 492, 552);
        stage.setMinWidth(492); stage.setMinHeight(552);
        stage.setMaxWidth(740); stage.setMaxHeight(800);
        stage.setResizable(true);
        scene.getStylesheets().add("/style.css");

        scene.setOnKeyPressed( e -> ControllerHandler.getInstance().shortcuts(e) );

        stage.setTitle(LanguageHandler.getInstance().APPLICATION_TITLE);
        stage.setScene(scene);
        stage.show();

    }

}
