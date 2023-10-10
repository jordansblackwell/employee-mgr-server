package com.Blackwell.Jordan.employeemanagerserver.domain.employee.services;

import com.Blackwell.Jordan.employeemanagerserver.domain.core.exceptions.ResourceCreationException;
import com.Blackwell.Jordan.employeemanagerserver.domain.core.exceptions.ResourceNotFoundException;
import com.Blackwell.Jordan.employeemanagerserver.domain.employee.models.Employee;
import com.Blackwell.Jordan.employeemanagerserver.domain.employee.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
    private EmployeeRepo employeeRepo;


    @Autowired
    public EmployeeServiceImplementation(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee create(Employee employee) throws ResourceCreationException {
        Optional<Employee> optional = employeeRepo.findByEmail(employee.getEmail());
        if (optional.isPresent())
            throw new ResourceCreationException("Employee with email exists: " + employee.getEmail());
        employee = employeeRepo.save(employee);
        return employee;

    }

    @Override
    public Employee getById(Long id) throws ResourceCreationException {
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No employee with id: " + id));
        return employee;
    }

    @Override
    public Employee getByEmail(String email) throws ResourceNotFoundException {
       Employee employee = employeeRepo.findByEmail(email)
               .orElseThrow(()->new ResourceNotFoundException("No Employee with email: " + email));
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee update(Long id, Employee employeeDetail) throws ResourceNotFoundException {
        Employee employee = getById(id);
                employee.setFirstName(employee.getFirstName());
                employee.setLastName(employeeDetail.getLastName());
                employee.setEmail(employeeDetail.getEmail());
                employee = employeeRepo.save(employee);

        return employee;
    }

    @Override
    public void delete(Long id) {
        Employee employee = getById(id);
        employeeRepo.delete(employee);
    }



}
