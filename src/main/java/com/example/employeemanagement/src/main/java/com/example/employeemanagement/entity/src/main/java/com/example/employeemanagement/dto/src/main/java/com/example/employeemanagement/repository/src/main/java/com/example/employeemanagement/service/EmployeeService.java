package com.example.employeemanagement.service;

import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Create Employee
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

        Employee employee = new Employee();

        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setSalary(employeeDTO.getSalary());
        employee.setDepartment(employeeDTO.getDepartment());

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDTO responseDTO = new EmployeeDTO();

        responseDTO.setName(savedEmployee.getName());
        responseDTO.setEmail(savedEmployee.getEmail());
        responseDTO.setSalary(savedEmployee.getSalary());
        responseDTO.setDepartment(savedEmployee.getDepartment());

        return responseDTO;
    }

    // Get All Employees
    public List<EmployeeDTO> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();

        return employees.stream()
                .map(employee -> {
                    EmployeeDTO dto = new EmployeeDTO();

                    dto.setName(employee.getName());
                    dto.setEmail(employee.getEmail());
                    dto.setSalary(employee.getSalary());
                    dto.setDepartment(employee.getDepartment());

                    return dto;
                })
                .collect(Collectors.toList());
    }
}
