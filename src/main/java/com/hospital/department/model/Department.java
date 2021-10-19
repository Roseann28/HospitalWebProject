package com.hospital.department.model;

public class Department {
    private int departmentId;
    private String depertmentName;

    public Department() {
    }

    public Department(int departmentId, String depertmentName) {
        this.departmentId = departmentId;
        this.depertmentName = depertmentName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepertmentName() {
        return depertmentName;
    }

    public void setDepertmentName(String depertmentName) {
        this.depertmentName = depertmentName;
    }
}
