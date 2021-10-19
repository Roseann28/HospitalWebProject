package com.hospital.login.model;

public class Register {
    private String name;
    private String staffId;
    private String password;

    public Register(String name, String staffId, String password) {
        this.name = name;
        this.staffId = staffId;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
