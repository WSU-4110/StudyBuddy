module com.example.studdybuddy {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.studdybuddy to javafx.fxml;
    exports com.example.studdybuddy;
}