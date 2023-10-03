package net.didier.springbootbacke.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import net.didier.springbootbacke.model.Employee;
import net.didier.springbootbacke.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    

    // build create employee Rest API

    @PostMapping

    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){

        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);


    }
}
