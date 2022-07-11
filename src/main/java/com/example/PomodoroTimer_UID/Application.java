package com.example.PomodoroTimer_UID;

import javafx.stage.Stage;

import java.io.IOException;

/* IMMAGINI PRESE DA https://www.flaticon.com/ */
public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {

        /* affido lo stage allo SceneHandler in quanto ho bisogno di una classe singleton che mi permetta di ..
        .. far interagire il codice, con la dimensione della finestra */
        SceneHandler.getInstance().init(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}