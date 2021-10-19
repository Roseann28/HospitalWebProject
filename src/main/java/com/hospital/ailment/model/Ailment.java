package com.hospital.ailment.model;

public class Ailment {
    private int doctorId;
    private int patientId;
    private String ailment;
    private String medicine;
    private String test;
    private String admitted;

    public Ailment() {
    }

    public Ailment(int doctorId, int patientId, String ailment, String medicine, String test, String admitted) {
        this.ailment = ailment;
        this.medicine = medicine;
        this.doctorId = doctorId;
        this.test = test;
        this.admitted = admitted;
        this.patientId=patientId;

    }


    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getAdmitted() {
        return admitted;
    }

    public void setAdmitted(String admitted) {
        this.admitted = admitted;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getAilment() {
        return ailment;
    }

    public void setAilment(String ailment) {
        this.ailment = ailment;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }
}
