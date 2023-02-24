package DAO;

import connection.MyConnection;
import model.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
    private final Connection connection;
    private final String SELECT_ALL = "select * from department;";
    private final String SELECT_BY_ID = "select * from department where id = ?;";

    public DepartmentDAO() {
        connection = MyConnection.getConnection();
    }

    public List<Department> findAll() {
        List<Department> departmentList = new ArrayList<>();
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                departmentList.add(new Department(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departmentList;
    }

    public Department findById(int id) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idDb = resultSet.getInt("id");
                String name = resultSet.getString("name");
                return new Department(idDb, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}