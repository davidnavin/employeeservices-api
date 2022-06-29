package com.example.Employee.repository;

import com.example.Employee.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    public Employee findByEmpId(Integer empId);

}
