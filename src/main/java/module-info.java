module com.example.studybuddy {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.studybuddy to javafx.fxml;
    exports com.example.studybuddy;
}