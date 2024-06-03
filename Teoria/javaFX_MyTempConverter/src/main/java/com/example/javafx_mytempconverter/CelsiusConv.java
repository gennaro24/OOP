package com.example.javafx_mytempconverter;

public class CelsiusConv {
    private final double  degreeCelsius;
    private double degreeFarenheit;

    CelsiusConv(double degree){
        this.degreeCelsius = degree;
        degreeFarenheit = 0;
    }

    public double getDegreeCelsius() {
        return degreeCelsius;
    }

    public double Convert(){
        degreeFarenheit = (degreeCelsius*1.8)+32;
        return degreeFarenheit;
    }

}
