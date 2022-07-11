module com.example.timer_test_24062022 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.PomodoroTimer_UID to javafx.fxml;
    exports com.example.PomodoroTimer_UID;
}