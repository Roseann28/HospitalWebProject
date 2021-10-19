package com.hospital.appointment.model;

import java.util.Date;

public class Book{
    private String id;
    private String name;
    private String email;
    private int nationalId;
    private int age;
    private String location;
    private String paymentMethod;
    private String dateOfBirth;

    public Book(){

    }

    public Book(String id, String name, String email,  int nationalId,int age,
                String location, String paymentMethod,String dateOfBirth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.nationalId = nationalId;
        this.location = location;
        this.paymentMethod = paymentMethod;
        this.dateOfBirth=dateOfBirth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNationalId() {
        return nationalId;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}