module com.example.studybuddy {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;
    requires org.testng;


    opens com.example.studybuddy to javafx.fxml;
    exports com.example.studybuddy;
}