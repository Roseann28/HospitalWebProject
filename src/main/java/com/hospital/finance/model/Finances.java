package com.hospital.finance.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Finances implements Serializable {
    private int patientId;
    private String service;
    private int quantity;
    private BigDecimal fee;
    private BigDecimal totalfee;

    public Finances(){

    }

    public Finances(int patientId, String service, int quantity, BigDecimal fee, BigDecimal totalfee) {
        this.patientId = patientId;
        this.service = service;
        this.quantity = quantity;
        this.fee = fee;
        this.totalfee = totalfee;
    }

    public BigDecimal getTotalfee() {
        return totalfee;
    }

    public void setTotalfee(BigDecimal totalfee) {
        this.totalfee = totalfee;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }
}
