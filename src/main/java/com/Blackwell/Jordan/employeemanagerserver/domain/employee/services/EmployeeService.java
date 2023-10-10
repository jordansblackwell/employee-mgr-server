package com.Blackwell.Jordan.employeemanagerserver.domain.employee.services;

import com.Blackwell.Jordan.employeemanagerserver.domain.core.exceptions.ResourceCreationException;
import com.Blackwell.Jordan.employeemanagerserver.domain.core.exceptions.ResourceNotFoundException;
import com.Blackwell.Jordan.employeemanagerserver.domain.employee.models.Employee;

import java.util.List;

public interface EmployeeService {

    Employee create(Employee employee) throws ResourceCreationException;
    Employee getById(Long id) throws ResourceCreationException;
    Employee getByEmail(String email) throws ResourceNotFoundException;
    List<Employee> getAll();
    Employee update(Long id, Employee employeeDetail) throws ResourceNotFoundException;
    void delete (Long id);
}
