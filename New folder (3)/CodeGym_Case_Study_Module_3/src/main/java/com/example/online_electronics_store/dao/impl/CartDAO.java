package com.example.online_electronics_store.dao.impl;

import com.example.online_electronics_store.dao.DBConnection;
import com.example.online_electronics_store.dao.ICartDAO;
import com.example.online_electronics_store.model.Cart;
import com.example.online_electronics_store.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAO implements ICartDAO {
    private final String SELECT_CART_BY_USER = "select * from cart where user_id = ?;";
    private final String SELECT_CART_BY_ID = "select * from cart where id = ?;";
    private final String INSERT_CART = "insert into cart (user_id) values (?);";
    private final String DELETE_CART = "delete from cart where id = ?;";
    DBConnection dbConn = DBConnection.getInstance();
    private static CartDAO instance;

    private CartDAO() {

    }

    public static CartDAO getInstance() {
        if (instance == null) {
            instance = new CartDAO();
        }
        return instance;
    }

    @Override
    public Cart findById(Long id) throws SQLException {
        try (Connection connection = dbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_CART_BY_ID)) {
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            return getList(result).get(0);
        }
    }

    @Override
    public List<Cart> findAll() throws SQLException {
        return null;
    }

    @Override
    public void insert(Cart cart) throws SQLException {
        try (Connection connection = dbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_CART)) {
            setStatement(cart, statement);
            statement.executeUpdate();
        }
    }

    @Override
    public boolean update(Long id, Cart cart) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Long id) throws SQLException {
        try (Connection connection = dbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_CART)) {
            statement.setLong(1, id);
            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public List<Cart> getList(ResultSet result) throws SQLException {
        List<Cart> carts = new ArrayList<>();
        while (result.next()) {
            Long id = result.getLong("id");
            Long user_id = result.getLong("user_id");
            carts.add(new Cart(id, UserDAO.getInstance().findById(user_id)));
        }
        return carts;
    }

    @Override
    public void setStatement(Cart cart, PreparedStatement statement) throws SQLException {
        statement.setLong(1, cart.getUser().getId());
    }

    @Override
    public Cart findByUser(User user) throws SQLException {
        try (Connection connection = dbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_CART_BY_USER)) {
            Long userId = user.getId();
            statement.setLong(1, userId);
            ResultSet result = statement.executeQuery();
            return getList(result).get(0);
        }
    }
}
