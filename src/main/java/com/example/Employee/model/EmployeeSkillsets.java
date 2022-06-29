package com.example.Employee.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name="employee_skillsets")
public class EmployeeSkillsets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empSkillId;
    private String skillName;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "EMP_ID")
    @JsonBackReference
    private Employee employee;

    public int getEmpSkillId() {
        return empSkillId;
    }

    public void setEmpSkillId(int empSkillId) {
        this.empSkillId = empSkillId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
