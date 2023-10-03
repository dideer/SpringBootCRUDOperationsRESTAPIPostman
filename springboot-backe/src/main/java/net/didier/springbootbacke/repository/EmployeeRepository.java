package net.didier.springbootbacke.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import net.didier.springbootbacke.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    
}
