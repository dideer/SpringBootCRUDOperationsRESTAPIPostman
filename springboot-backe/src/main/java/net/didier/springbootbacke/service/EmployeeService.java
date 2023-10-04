package net.didier.springbootbacke.service;

import java.util.*;
import net.didier.springbootbacke.model.Employee;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeId(long id);

    Employee updateEmployee(Employee employee,long id);

    void deleteEmployee(long id);
}
