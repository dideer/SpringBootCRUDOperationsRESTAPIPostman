package net.didier.springbootbacke.service.impl;

import org.springframework.stereotype.Service;

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
    
}
