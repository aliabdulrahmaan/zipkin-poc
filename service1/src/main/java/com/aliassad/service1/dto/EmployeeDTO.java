package com.aliassad.service1.dto;

public class EmployeeDTO {
    private Integer empId;
    private Integer depId;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "empId=" + empId +
                ", depId=" + depId +
                '}';
    }
}
