module com.example.javafx_mytempconverter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx_mytempconverter to javafx.fxml;
    exports com.example.javafx_mytempconverter;
}