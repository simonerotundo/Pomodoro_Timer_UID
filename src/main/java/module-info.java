module com.example.timer_test_24062022 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.timer_test_24062022 to javafx.fxml;
    exports com.example.timer_test_24062022;
}