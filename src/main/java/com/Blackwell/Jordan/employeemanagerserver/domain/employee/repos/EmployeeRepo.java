package com.Blackwell.Jordan.employeemanagerserver.domain.employee.repos;

import com.Blackwell.Jordan.employeemanagerserver.domain.employee.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);


}
