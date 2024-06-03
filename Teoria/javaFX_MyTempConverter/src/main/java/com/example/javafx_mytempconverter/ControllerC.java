package com.example.javafx_mytempconverter;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerC implements Initializable {
@FXML Button convertButton;
@FXML TextField insertValue;
@FXML Text result;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BooleanBinding disableConvert = Bindings.createBooleanBinding( () -> insertValue.getText().isEmpty() , insertValue.textProperty());
        convertButton.disableProperty().bind(disableConvert);
        result.setDisable(true);
    }
    @FXML
    public void Convert(){
        CelsiusConv c = new CelsiusConv( Double.parseDouble(insertValue.getText()) );
        result.setText( String.valueOf(c.Convert()));
        insertValue.clear();
    }

}