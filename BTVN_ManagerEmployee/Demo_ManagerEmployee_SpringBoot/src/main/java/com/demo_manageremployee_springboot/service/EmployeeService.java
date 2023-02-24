package com.demo_manageremployee_springboot.service;

import com.demo_manageremployee_springboot.model.Employee;
import com.demo_manageremployee_springboot.repository.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    IEmployeeRepo employeeRepo;

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) employeeRepo.findAll();
    }


    @Override
    public void save(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepo.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public Long countEmployee() {
        return employeeRepo.countEmployee();
    }
}
