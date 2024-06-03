package com.example.mid_term2324_otp_service;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.util.Random;

public class OTPService extends Service<Void> {
    SimpleStringProperty otpCode;
    OTPService( SimpleStringProperty otpCode){
        this.otpCode = otpCode;
    }

    @Override
    protected Task<Void> createTask() {
        return new Task<>() {
            @Override
            protected Void call() throws Exception {
                Random r = new Random();
                while (!isCancelled()){
                    Platform.runLater(() ->otpCode.setValue( String.valueOf(r.nextInt(500))));
                    Thread.sleep(10000);
                }
                return null;
            }
        };
    }
}
