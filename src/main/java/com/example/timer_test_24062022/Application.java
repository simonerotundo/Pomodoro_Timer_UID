package com.example.timer_test_24062022;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {

        SceneHandler.getInstance().init(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}