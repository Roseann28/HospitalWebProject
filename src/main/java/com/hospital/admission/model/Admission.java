package com.hospital.admission.model;

import java.util.Date;

public class Admission {
    private int staffId;
    private int patientId;
    private String roomNumber;
    private String dateOfAdmission;
    private String presentDate;
    private String progress;

    public Admission(int staffId, int patientId, String roomNumber, String dateOfAdmission, String presentDate, String progress) {
        this.staffId = staffId;
        this.patientId=patientId;
        this.roomNumber = roomNumber;
        this.dateOfAdmission = dateOfAdmission;
        this.presentDate = presentDate;
        this.progress = progress;
    }

    public Admission() {
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(String dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public String getPresentDate() {
        return presentDate;
    }

    public void setPresentDate(String presentDate) {
        this.presentDate = presentDate;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }
}
