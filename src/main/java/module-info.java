module com.example.studybuddy {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit4;
    requires org.testng;


    opens com.example.studybuddy to javafx.fxml;
    exports com.example.studybuddy;
}