package dao;

import models.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private Connection connection = ConnectionMySql.getConnection();
    public Account checkLogin(String username,String password){
        String sql = "select * from account where username =? and password =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int id = resultSet.getInt("id");
            String role = resultSet.getString("role");
            String img = resultSet.getString("img");

            return new Account(id,username,password,img,role);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

