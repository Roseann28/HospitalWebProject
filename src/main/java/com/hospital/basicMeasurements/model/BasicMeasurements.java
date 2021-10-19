package com.hospital.basicMeasurements.model;

public class BasicMeasurements {
    private double height;
    private double weight;
    private String bloodPressure;
    private double bmi;
    private int id;
    private String weightUnit;
    private String heightUnit;

    public BasicMeasurements(double height, double weight, String bloodPressure, double bmi, int id, String weightUnit, String heightUnit) {
        this.height = height;
        this.weight = weight;
        this.bloodPressure = bloodPressure;
        this.bmi = bmi;
        this.id = id;
        this.weightUnit = weightUnit;
        this.heightUnit = heightUnit;
    }

    public BasicMeasurements(int id,double height, double weight, String bloodPressure, double bmi) {
        this.height = height;
        this.weight = weight;
        this.bloodPressure = bloodPressure;
        this.bmi = bmi;
        this.id = id;
    }

    public BasicMeasurements() {
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    public String getHeightUnit() {
        return heightUnit;
    }

    public void setHeightUnit(String heightUnit) {
        this.heightUnit = heightUnit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }
}
