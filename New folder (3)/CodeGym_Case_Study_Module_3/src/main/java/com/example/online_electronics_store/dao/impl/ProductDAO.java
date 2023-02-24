package com.example.online_electronics_store.dao.impl;

import com.example.online_electronics_store.dao.DBConnection;
import com.example.online_electronics_store.dao.IProductDAO;
import com.example.online_electronics_store.model.Category;
import com.example.online_electronics_store.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    private final String SELECT_PRODUCT_BY_ID = "select * from product where id = ?;";
    private final String SELECT_PRODUCT_BY_NAME = "select * from product where name = ?;";
    private final String SELECT_PRODUCT_BY_CATEGORY = "select * from product where category_id = ?;";
    private final String SELECT_ALL_PRODUCT = "select * from product;";
    private final String SELECT_PRODUCT_BY_PRICE = "select * from product where price between ? and ?;";
    private final String SELECT_PRODUCT_BY_INDEX = "select * from product order by id limit ?,6;";
    private final String SELECT_COUNT = "select count(id) from product;";
    private final String INSERT_PRODUCT = "insert into product (name, price, description, image, stock_status, category_id) values (?,?,?,?,?,?);";
    private final String UPDATE_PRODUCT = "update product set name = ?, price = ?, description = ?, image = ?, stock_status = ?, category_id = ? where id = ?;";
    private final String DELETE_PRODUCT = "delete from product where id = ?;";
    private final String SORT_BY_CONDITION = "select * from product order by ";
    private final String SELECT_PRODUCT_BY_SEARCH_NAME = "select * from product where name like ?;";
    DBConnection dbConn = DBConnection.getInstance();
    private static ProductDAO instance;

    private ProductDAO() {
    }

    public static ProductDAO getInstance() {
        if (instance == null) {
            instance = new ProductDAO();
        }
        return instance;
    }

    @Override
    public Product findById(Long id) throws SQLException {
        try (Connection connection = dbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_PRODUCT_BY_ID)) {
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            return getList(result).get(0);
        }
    }

    @Override
    public List<Product> findAll() throws SQLException {
        try (Connection connection = dbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_PRODUCT)) {
            ResultSet result = statement.executeQuery();
            return getList(result);
        }
    }

    @Override
    public void insert(Product product) throws SQLException {
        try (Connection connection = dbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_PRODUCT)) {
            setStatement(product, statement);
            statement.executeUpdate();
        }
    }

    @Override
    public boolean update(Long id, Product product) throws SQLException {
        try (Connection connection = dbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT)) {
            setStatement(product, statement);
            statement.setLong(7, id);
            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(Long id) throws SQLException, ClassNotFoundException {
        try (Connection connection = dbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT)) {
            statement.setLong(1, id);
            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public List<Product> getList(ResultSet result) throws SQLException {
        List<Product> products = new ArrayList<>();
        while (result.next()) {
            Long id = result.getLong("id");
            String name = result.getString("name");
            Double price = result.getDouble("price");
            String description = result.getString("description");
            String image = result.getString("image");
            boolean stockStatus = result.getBoolean("stock_status");
            Long categoryId = result.getLong("category_id");
            Category category = CategoryDAO.getInstance().findById(categoryId);
            products.add(new Product(id, name, price, description, image, stockStatus, category));
        }
        return products;
    }

    @Override
    public Product findByName(String name) throws SQLException {
        try (Connection connection = dbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_PRODUCT_BY_NAME)) {
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();
            return getList(result).get(0);
        }
    }

    @Override
    public List<Product> sort(String condition) throws SQLException {
        final String FULL_SORT_SQL = SORT_BY_CONDITION + condition + ";";
        try (Connection connection = dbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement(FULL_SORT_SQL)) {
            ResultSet result = statement.executeQuery();
            return getList(result);
        }
    }

    public void setStatement(Product product, PreparedStatement statement) throws SQLException {
        statement.setString(1, product.getName());
        statement.setDouble(2, product.getPrice());
        statement.setString(3, product.getDescription());
        statement.setString(4, product.getImage());
        statement.setBoolean(5, product.isStockStatus());
        statement.setLong(6, product.getCategory().getId());
    }

    @Override
    public List<Product> pagingProduct(int index) throws SQLException {
        try (Connection connection = dbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_PRODUCT_BY_INDEX)) {
            statement.setInt(1, index);
            ResultSet result = statement.executeQuery();
            return getList(result);
        }
    }

    @Override
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

    public List<Product> findByCategory(Long id) throws SQLException {
        try (Connection connection = dbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_PRODUCT_BY_CATEGORY)) {
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            return getList(result);
        }
    }

    public List<Product> findByPrice(Double start, Double end) throws SQLException {
        try (Connection connection = dbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_PRODUCT_BY_PRICE)) {
            statement.setDouble(1, start);
            statement.setDouble(2, end);
            ResultSet result = statement.executeQuery();
            return getList(result);
        }
    }

    public List<Product> findBySearchName(String name) throws SQLException {
        try(Connection connection = dbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_PRODUCT_BY_SEARCH_NAME)) {
            statement.setString(1,"%" + name + "%");
            ResultSet result = statement.executeQuery();
            return getList(result);
        }
    }
}

