package com.example.Employee.repository;

import com.example.Employee.model.EmployeeSkillsets;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeSkillsetsRepository extends CrudRepository<EmployeeSkillsets, Integer> {
}
