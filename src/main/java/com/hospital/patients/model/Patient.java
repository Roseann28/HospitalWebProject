package com.hospital.patients.model;

import java.util.Date;

public class Patient {
    private int id;
    private String name;
    private String email;
    private int nationalId;
    private String paymentMethod;
    private String specialist;
    private String doctor;
    private Date dateOfBirth;

    public Patient(int id, String name, String email, int nationalId, String paymentMethod,String specialist,String doctor,Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.nationalId = nationalId;
        this.paymentMethod = paymentMethod;
        this.specialist=specialist;
        this.doctor=doctor;
        this.dateOfBirth=dateOfBirth;

    }

    public Patient() {
    }
    public Patient(int id, String name,String paymentMethod,String specialist,String doctor,Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.nationalId = nationalId;
        this.paymentMethod = paymentMethod;
        this.specialist=specialist;
        this.doctor=doctor;
        this.dateOfBirth=dateOfBirth;

    }




    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public int getNationalId() {
        return nationalId;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String addPatient() {
        String query = "insert into patient(name,email,identificationNumber,paymentmethod) values("
                + "'"+getName()+"'," + "'" + getEmail() + "'," +
                    "'" + getNationalId() + "'," + "'" + getPaymentMethod() + "')";

        return query;
    }
        public String updatePatient(){
        String query;
            query = "update patient set ";

            String setCol = "";

            if (getName() != null && !setCol.trim().equals(""))
                setCol += "name='" + getName();

            if (getEmail() != null && !setCol.trim().equals(""))
                setCol += "email='" + getEmail();

            if (getNationalId() != 0 && !setCol.trim().equals(""))
                setCol += "identificationNumber='" +getNationalId();

            if (getPaymentMethod() != null && !setCol.trim().equals(""))
                setCol += "paymentmethod='" + getPaymentMethod();

            query += setCol;

            query += " where id=" + getId();
            return query;
        }
}
