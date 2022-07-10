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


    private final int MIN_WIDTH = 492, MIN_HEIGHT = 552;
    private final int MAX_WIDTH = 740, MAX_HEIGHT = 880;
    private final int DEFAULT_WIDTH = MIN_WIDTH, DEFAULT_HEIGH = MIN_HEIGHT;



    public void init(Stage stage) throws IOException {

        this.stage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("home.fxml"));
        scene = new Scene(fxmlLoader.load(), DEFAULT_WIDTH, DEFAULT_HEIGH);
        stage.setMinWidth(MIN_WIDTH); stage.setMinHeight(MIN_HEIGHT);
        stage.setMaxWidth(MAX_WIDTH); stage.setMaxHeight(MAX_HEIGHT);
        stage.setResizable(true);
        scene.getStylesheets().add("/style.css");

        scene.setOnKeyPressed( e -> ControllerHandler.getInstance().shortcuts(e) );

        stage.setTitle(LanguageHandler.getInstance().APPLICATION_TITLE);
        stage.setScene(scene);
        stage.show();

    }

}
