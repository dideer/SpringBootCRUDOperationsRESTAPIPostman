package net.didier.springbootbacke.controller;

import java.util.List;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    // build get all employee rest api
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    // build get employee by id rest api
    //http://localhost:8080/api/employees/1
   
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeId(@PathVariable("id") Long employeeId){
        return new ResponseEntity<Employee>(employeeService.getEmployeeId(employeeId),HttpStatus.OK);
    }

    //http://localhost:8080/api/employees/1
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long idd,@RequestBody Employee employee){


        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, idd),HttpStatus.OK);
    }
} 
