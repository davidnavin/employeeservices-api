package com.example.Employee.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    @Column(name="emp_name")
    private String empName;
    @Column(name="emp_address")
    private String address;
    @Column(name="salary")
    private Float salary;
    @Column(name="bonus_percent")
    private Float bonusPercent;

    @OneToMany(fetch = FetchType.EAGER,mappedBy="employee",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<EmployeeSkillsets> employeeSkillsets;

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

    public Float getBonusPercent() {
        return bonusPercent;
    }

    public void setBonusPercent(Float bonusPercent) {
        this.bonusPercent = bonusPercent;
    }
}
