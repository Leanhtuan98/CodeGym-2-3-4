package com.example.module_3_final_exam.DAO;

import com.example.module_3_final_exam.connection.MyConnection;
import com.example.module_3_final_exam.model.Department;
import com.example.module_3_final_exam.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private Connection connection;
    private DepartmentDAO departmentDAO;
    private final String SELECT_ALL = "select * from employee;";
    private final String INSERT_EMPLOYEE = "insert into employee (name, email, address, phone_number, salary, department_id)" +
            "value (?,?,?,?,?,?);";
    private final String DELETE_BY_ID = "delete from employee where id = ?;";
    private final String UPDATE_EMPLOYEE = "update employee set name = ?, email = ?, address = ?, phone_number = ?, salary = ?, department_id = ? where id = ?;";
    private final String SEARCH_EMPLOYEE = "select * from employee where name like concat('%',?,'%');";


    public EmployeeDAO() {
        connection = MyConnection.getConnection();
        departmentDAO = new DepartmentDAO();
    }

    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phone_number");
                Double salary = resultSet.getDouble("salary");
                Long departmentId = resultSet.getLong("department_id");
                Department department = departmentDAO.findById(departmentId);
                employeeList.add(new Employee(id, name, email, address, phoneNumber, salary, department));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public boolean createEmployee(Employee employee) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(INSERT_EMPLOYEE)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.setDouble(5, employee.getSalary());
            preparedStatement.setLong(6, employee.getDepartment().getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(Long id) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)) {
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        }
    }

    public boolean update(Employee employee) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.setDouble(5, employee.getSalary());
            preparedStatement.setLong(6, employee.getDepartment().getId());
            preparedStatement.setLong(7, employee.getId());
            return preparedStatement.executeUpdate() > 0;
        }
    }

    public List<Employee> search(String string) throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_EMPLOYEE)) {
            preparedStatement.setString(1, string);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phone_number");
                Double salary = resultSet.getDouble("salary");
                Long departmentId = resultSet.getLong("department_id");
                Department department = departmentDAO.findById(departmentId);
                employeeList.add(new Employee(id, name, email, address, phoneNumber, salary, department));
            }
        } catch (SQLException e){
            e.printStackTrace();
    }
        return employeeList;
}


}
