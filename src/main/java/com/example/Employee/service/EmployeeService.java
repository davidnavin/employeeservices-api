package com.example.Employee.service;

import com.example.Employee.dto.EmployeeDTO;
import com.example.Employee.model.Employee;

import java.util.List;

public interface EmployeeService {

    public List<EmployeeDTO> getEmployees(Integer empId);

    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO);

    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);

    public String deleteEmployee(Integer empId) throws Exception;
}
