package com.hospital.basicMeasurements.bean;

public class BmiConversion {

    public double conversionResult(double weight, double height, String unitWeight, String unitHeight) {
        if (unitWeight.equals("pounds")) {
            weight = (weight / 2.205);
        }
        if (unitHeight.equals("feet")) {
            height = (height / 3.28084);
        }
        double resultBMI = weight / (Math.pow(height, 2));
        return resultBMI;
    }
}
