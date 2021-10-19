package com.hospital.staff.model;

public class Staff {
    private String name;
    private int staffId;
    private String department;
    private String specialisation;

    public Staff(int staffId, String name, String department, String specialisation) {
        this.name = name;
        this.staffId = staffId;
        this.department = department;
        this.specialisation = specialisation;
    }
    public Staff(){

    }


    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


}