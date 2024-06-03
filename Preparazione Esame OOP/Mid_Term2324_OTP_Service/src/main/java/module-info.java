module com.example.mid_term2324_otp_service {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mid_term2324_otp_service to javafx.fxml;
    exports com.example.mid_term2324_otp_service;
}