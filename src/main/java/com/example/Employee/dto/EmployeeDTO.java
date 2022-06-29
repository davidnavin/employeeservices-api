package com.example.Employee.dto;

import com.example.Employee.model.EmployeeSkillsets;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDTO {
    private int empId;
    private String empName;
    private String address;
    private Float salary;
    private Float bonus;
    private Float bonusPercent;
    private String message;
    private List<EmployeeSkillsets> employeeSkillsets;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Float getBonusPercent() {
        return bonusPercent;
    }

    public void setBonusPercent(Float bonusPercent) {
        this.bonusPercent = bonusPercent;
    }

    public List<EmployeeSkillsets> getEmployeeSkillsets() {
        return employeeSkillsets;
    }

    public void setEmployeeSkillsets(List<EmployeeSkillsets> employeeSkillsets) {
        this.employeeSkillsets = employeeSkillsets;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Float getBonus() {
        return bonus;
    }

    public void setBonus(Float bonus) {
        this.bonus = bonus;
    }
}
