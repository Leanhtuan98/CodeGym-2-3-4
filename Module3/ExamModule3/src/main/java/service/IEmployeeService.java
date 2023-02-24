package service;

import model.Employee;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IEmployeeService extends ICoreCRUDService<Employee,Long> {
    List<Employee> findByNameContaining(HttpServletRequest request);
}