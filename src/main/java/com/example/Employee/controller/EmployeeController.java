package com.example.Employee.controller;

import com.example.Employee.dto.EmployeeDTO;
import com.example.Employee.model.Employee;
import com.example.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/all")
    public List<EmployeeDTO> getEmployees(@RequestParam(required = false) Integer empId){
        return (List<EmployeeDTO>) employeeService.getEmployees(empId);
    }

    @PostMapping(value = "/add")
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO){
        return (EmployeeDTO) employeeService.addEmployee(employeeDTO);
    }

    @PutMapping(value = "/update")
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO){
        return (EmployeeDTO) employeeService.updateEmployee(employeeDTO);
    }

    @DeleteMapping(value = "/delete")
    public String deleteEmployee(@RequestParam Integer empId) throws Exception{
        try{
            return employeeService.deleteEmployee(empId);
        } catch (Exception e){
            return e.getMessage();
        }

    }
}
