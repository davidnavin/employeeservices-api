package com.example.Employee.service;

import com.example.Employee.dto.EmployeeDTO;
import com.example.Employee.model.Employee;
import com.example.Employee.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDTO> getEmployees(Integer empId) {
        float bonus = 0.0f;
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        List<Employee> employeeList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();

        if(empId == null) {
            employeeList = (List<Employee>) employeeRepository.findAll();
        }
        else {
            Employee employee = employeeRepository.findByEmpId(empId);
            employeeList.add(employee);
        }

        for (Employee employee : employeeList) {
            EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
            bonus = employee.getSalary() * (employee.getBonusPercent()/100);
            employeeDTO.setBonus(bonus);
            employeeDTO.setMessage("SUCCESS");
            employeeDTOList.add(employeeDTO);
        }

        return employeeDTOList;
    }

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO){
        ModelMapper modelMapper = new ModelMapper();
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        EmployeeDTO employeeDTO1 = modelMapper.map(employeeRepository.save(employee), EmployeeDTO.class);
        employeeDTO1.setMessage("SUCCESS - Inserted record");
        return(employeeDTO1);
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO){
        ModelMapper modelMapper = new ModelMapper();
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        System.out.println("Before Emp Id "+employee.getEmpId());
        Employee employee1 = employeeRepository.findByEmpId(employeeDTO.getEmpId());
        System.out.println("After Emp Id "+employee1.getEmpId());
        EmployeeDTO employeeDTO1 = employeeDTO;
        if (employee.getEmpId() == employee1.getEmpId()) {
            System.out.println("Inside");
            employeeDTO1 = modelMapper.map(employeeRepository.save(employee), EmployeeDTO.class);
            employeeDTO1.setMessage("SUCCESS - Updated record");
        }
        else {
            employeeDTO1.setMessage("FAILURE - Employee not found");
        }
        return employeeDTO1;
    }

    @Override
    public String deleteEmployee(Integer empId) throws Exception{
        try{
            employeeRepository.deleteById(empId);
            return "Employee Emp Id "+empId+" successfully deleted";
        } catch(Exception e) {
            return "Delete for Emp Id "+empId+" failed "+e.getMessage();
        }
    }
}
