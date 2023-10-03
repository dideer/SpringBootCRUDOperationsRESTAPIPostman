package net.didier.springbootbacke.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import net.didier.springbootbacke.exception.ResourceNotFound;
import net.didier.springbootbacke.model.Employee;
import net.didier.springbootbacke.repository.EmployeeRepository;
import net.didier.springbootbacke.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee saveEmployee(Employee employee) {
      
        return employeeRepository.save(employee);
    }


    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


    @Override
    public Employee getEmployeeId(long id) {
        // Optional<Employee> employee =employeeRepository.findById(id);
    
        // if(employee.isPresent()){

        //     return employee.get();
        // }
        // else{
        //     throw new ResourceNotFound("Employee","Id",id);
        // }

        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Employee", "id", id));
    }


    @Override
    public Employee updateEmployee(Employee employee, long id) {
        
        //we need to check whether employee with given id is exist in db or not 

        Employee existingEmployee=employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Employee", "id", id));


        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmailId(employee.getEmailId());

        employeeRepository.save(existingEmployee);

        return existingEmployee;
    }


   
    
    
}
