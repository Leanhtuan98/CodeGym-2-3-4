package com.example.module_3_final_exam.service;

import com.example.module_3_final_exam.model.Employee;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IEmployeeService extends ICoreCRUDService<Employee,Long> {
    List<Employee> findByNameContaining(HttpServletRequest request);
}
