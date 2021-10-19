package com.hospital.patients.model;

public class Order {
    private String patientid;
    private String name;
    private String dateOfBirth;
    private String specialist;
    private String doctor;
    private String paymentMethod;

    public Order(String patientid, String name, String dateOfBirth, String specialist, String doctor,String paymentMethod) {
        this.patientid = patientid;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.specialist = specialist;
        this.doctor = doctor;
        this.paymentMethod=paymentMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
}
