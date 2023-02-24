package service.impl;

import DAO.DepartmentDAO;
import DAO.EmployeeDAO;
import model.Department;
import model.Employee;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImpl {
    private EmployeeDAO employeeDAO;
    private DepartmentDAO departmentDAO;

    public EmployeeServiceImpl() {
        employeeDAO = new EmployeeDAO();
        departmentDAO = new DepartmentDAO();
    }
    public List<Employee> findAll(HttpServletRequest request) {
        return employeeDAO.findAll();
    }


    public Employee findById(HttpServletRequest request) {
        return null;
    }


    public boolean save(HttpServletRequest request) {
        return false;
    }

    public void create(HttpServletRequest request) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        Double salary = Double.parseDouble(request.getParameter("salary"));
        int departmentId = Integer.parseInt(request.getParameter("department"));
        Department department = departmentDAO.findById(departmentId);
        employeeDAO.createEmployee(new Employee(name,email,address,phoneNumber,salary,department));
    }
    public boolean deleteById(HttpServletRequest request) {
        return false;
    }

    public void deleteEmployee(HttpServletRequest request) throws SQLException {
        Long id = Long.parseLong(request.getParameter("id"));
        employeeDAO.delete(id);
    }

    public List<Employee> findByNameContaining(HttpServletRequest request) {
        return null;
    }
    public void updateEmployee(HttpServletRequest request) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        Double salary = Double.parseDouble(request.getParameter("salary"));
        int departmentId = Integer.parseInt(request.getParameter("department"));
        Department department = departmentDAO.findById(departmentId);
        employeeDAO.update(new Employee(id,name,email,address,phoneNumber,salary,department));
    }

    public List<Employee> searchEmployee(HttpServletRequest request) throws SQLException {
        String string = request.getParameter("nameSearch");
        return employeeDAO.search(string);
    }
}
