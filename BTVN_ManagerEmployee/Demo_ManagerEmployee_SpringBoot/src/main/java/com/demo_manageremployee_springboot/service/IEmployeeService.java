package com.demo_manageremployee_springboot.service;

import com.demo_manageremployee_springboot.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    void save(Employee product);

    Employee findById(Long id);

    void delete(Long id);
    Long countEmployee();


}
