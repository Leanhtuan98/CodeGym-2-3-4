package com.demo_manageremployee_springboot.controller;

import com.demo_manageremployee_springboot.model.Employee;
import com.demo_manageremployee_springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping
    public List<Employee> getAll() {
        return employeeService.findAll();
    }
    @GetMapping("/count")
    public ResponseEntity<Long> countProduct() {
        return new ResponseEntity<>(employeeService.countEmployee(), HttpStatus.OK);
    }

    @PostMapping
    public void create(@RequestBody Employee employee){
         employeeService.save(employee);
    }

    @GetMapping("/{id}")
    public Employee showEdit(@PathVariable Long id){
        return employeeService.findById(id);
    }

    @PutMapping("/{id}")
    public void edit(@RequestBody Employee employee){
        employeeService.save(employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
         employeeService.delete(id);
    }
}
