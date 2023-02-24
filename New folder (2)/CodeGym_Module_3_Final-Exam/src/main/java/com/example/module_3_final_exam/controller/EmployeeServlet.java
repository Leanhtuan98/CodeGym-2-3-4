package com.example.module_3_final_exam.controller;

import com.example.module_3_final_exam.DAO.DepartmentDAO;
import com.example.module_3_final_exam.model.Department;
import com.example.module_3_final_exam.model.Employee;
import com.example.module_3_final_exam.service.impl.EmployeeServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employee")
public class EmployeeServlet extends HttpServlet {
    private EmployeeServiceImpl employeeService;
    private DepartmentDAO departmentDAO;

    @Override
    public void init() throws ServletException {
        employeeService = new EmployeeServiceImpl();
        departmentDAO = new DepartmentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            controller(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            controller(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void controller(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
            case "update":
                update(request,response);
                break;
            case "search":
                search(request,response);
                break;
            default:
                displayAll(request,response);
        }
    }

    private void displayAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        List<Employee> employeeList = employeeService.findAll(request);
        List<Department> departments = departmentDAO.findAll();
        request.setAttribute("employees", employeeList);
        request.setAttribute("departments", departments);
        dispatcher.forward(request,response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
        employeeService.create(request);
        response.sendRedirect("http://localhost:8080/employee");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        employeeService.deleteEmployee(request);
        response.sendRedirect("http://localhost:8080/employee");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        employeeService.updateEmployee(request);
        response.sendRedirect("http://localhost:8080/employee");
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Employee> employeeList = employeeService.searchEmployee(request);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        request.setAttribute("employees",employeeList);
        request.setAttribute("departments",departmentDAO.findAll());
        dispatcher.forward(request,response);
    }
}
