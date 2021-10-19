package com.hospital.test.model;

public class Tests {
    private String testName;
    private String finding;
    private int labTechId;
    private int patientId;

    public Tests(int labTechId, int patientId, String testName, String finding) {
        this.testName = testName;
        this.finding = finding;
        this.labTechId = labTechId;
        this.patientId=patientId;
    }

    public Tests() {
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getLabTechId() {
        return labTechId;
    }

    public void setLabTechId(int labTechId) {
        this.labTechId = labTechId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getFinding() {
        return finding;
    }

    public void setFinding(String finding) {
        this.finding = finding;
    }
}
