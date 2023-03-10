package com.example.online_electronics_store.dao.impl;

import com.example.online_electronics_store.dao.DBConnection;
import com.example.online_electronics_store.dao.IUserDAO;
import com.example.online_electronics_store.model.Cart;
import com.example.online_electronics_store.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private final String SELECT_USER_BY_ID = "select * from user where id = ?;";
    private final String SELECT_USER_BY_NAME = "select * from user where name = ?;";
    private final String SELECT_USER_BY_EMAIL = "select * from user where email = ?;";
    private final String SELECT_ALL_USER = "select * from user;";
    private final String INSERT_USER = "insert into user (role, username, password, phone_number, email, address) values ('user',?,?,?,?,?);";
    private final String UPDATE_USER = "update user set phone_number = ?, email = ?, address = ? where id = ?;";
    private final String DELETE_USER = "delete from user where id = ?;";
    private final String SELECT_COUNT = "select count(id) from user;";

    DBConnection dbConn = DBConnection.getInstance();
    private static UserDAO instance;

    private UserDAO() {
    }

    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }
    @Override
    public User findById(Long id) throws SQLException {
        try (Connection connection = dbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            return getList(result).get(0);
        }
    }

    @Override
    public List<User> findAll() throws SQLException {
        try (Connection connection = dbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_USER)) {
            ResultSet result = statement.executeQuery();
            return getList(result);
        }
    }

    @Override
        public void insert(User user) throws SQLException {
            try (Connection connection = dbConn.getConnection();
                PreparedStatement statement = connection.prepareStatement(INSERT_USER)) {
                setStatement(user, statement);
                statement.executeUpdate();
                CartDAO.getInstance().insert(new Cart(user));
            }
        }

    @Override
    public boolean update(Long id, User user) throws SQLException {
        try (Connection connection = dbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_USER)) {
            statement.setString(1, user.getPhoneNumber());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getAddress());
            statement.setLong(4, id);
            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(Long id) throws SQLException {
        try (Connection connection = dbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_USER)) {
            statement.setLong(1, id);
            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public List<User> getList(ResultSet result) throws SQLException {
        List<User> users = new ArrayList<>();
        while (result.next()) {
            Long id = result.getLong("id");
            String role = result.getString("role");
            String username = result.getString("username");
            String password = result.getString("password");
            String phoneNumber = result.getString("phone_number");
            String email = result.getString("email");
            String address = result.getString("address");
            users.add(new User(id, role, username, password, phoneNumber, email, address));
        }
        return users;
    }

    @Override
    public void setStatement(User user, PreparedStatement statement) throws SQLException {
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        statement.setString(3, user.getPhoneNumber());
        statement.setString(4, user.getEmail());
        statement.setString(5, user.getAddress());
    }
    public int getTotalCount() throws SQLException {
        try (Connection connection = dbConn.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_COUNT)) {
            ResultSet result = statement.executeQuery();
            int count = 0;
            while (result.next()) {
                count = result.getInt(1);
            }
            return count;
        }
    }
}
