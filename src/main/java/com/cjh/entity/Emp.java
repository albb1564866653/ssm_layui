package com.cjh.entity;

public class Emp {
    private Integer empId;
    private String empName;
    private char gender;
    private String email;
    private Integer deptId;
    private String deptName;

    public Emp() {
    }

    public Emp(Integer empId, String empName, char gender, String email, Integer deptId, String deptName) {
        this.empId = empId;
        this.empName = empName;
        this.gender = gender;
        this.email = email;
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
