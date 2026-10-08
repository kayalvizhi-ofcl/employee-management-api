package com.example.employeemanagement.controller;

import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Create Employee
    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(
            @RequestBody EmployeeDTO employeeDTO) {

        EmployeeDTO savedEmployee =
                employeeService.createEmployee(employeeDTO);

        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Get All Employees
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {

        List<EmployeeDTO> employees =
                employeeService.getAllEmployees();

        return ResponseEntity.ok(employees);
    }
}
