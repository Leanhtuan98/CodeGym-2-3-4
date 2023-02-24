package com.example.online_electronics_store.dao.impl;

import com.example.online_electronics_store.dao.DBConnection;
import com.example.online_electronics_store.dao.IFeedbackDAO;
import com.example.online_electronics_store.model.Feedback;
import com.example.online_electronics_store.model.Product;
import com.example.online_electronics_store.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FeedbackDAO implements IFeedbackDAO {
    private final String SELECT_BY_PRODUCT = "select * from feedback where product_id = ?;";
    private final String INSERT_FEEDBACK = "insert into feedback (user_id, product_id, rate, comment, date) values (?,?,?,?,?);";
    private final String UPDATE_FEEDBACK = "update feedback set rate = ?, comment = ?, date = ? where user_id = ? and product_id = ?;";
    private final String FIND_AVG_RATE_OF_PRODUCT = "select avg(rate) as avg from feedback where product_id = ?";
    DBConnection dbConn = DBConnection.getInstance();
    private static FeedbackDAO instance;

    private FeedbackDAO() {

    }

    public static FeedbackDAO getInstance() {
        if (instance == null) {
            instance = new FeedbackDAO();
        }
        return instance;
    }
    @Override
    public Feedback findById(Product id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<Feedback> findAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    public List<Feedback> findByProduct(Product product) throws SQLException {
        try (PreparedStatement statement = dbConn.getConnection().prepareStatement(SELECT_BY_PRODUCT)) {
            statement.setLong(1, product.getId());
            ResultSet result = statement.executeQuery();
            return getList(result);
        }
    }

    @Override
    public void insert(Feedback feedback) throws SQLException, ClassNotFoundException {
        try (PreparedStatement statement = dbConn.getConnection().prepareStatement(INSERT_FEEDBACK)) {
            statement.setLong(1, feedback.getUser().getId());
            statement.setLong(2, feedback.getProduct().getId());
            statement.setInt(3, feedback.getRate());
            statement.setString(4, feedback.getComment());
            Timestamp timestamp = Timestamp.valueOf(feedback.getDate());
            statement.setTimestamp(5, timestamp);
            statement.executeUpdate();
        }
    }

    @Override
    public boolean update(Product id, Feedback feedback) throws SQLException, ClassNotFoundException {
        try (PreparedStatement statement = dbConn.getConnection().prepareStatement(UPDATE_FEEDBACK)) {
            statement.setInt(1, feedback.getRate());
            statement.setString(2, feedback.getComment());
            Timestamp timestamp = Timestamp.valueOf(feedback.getDate());
            statement.setTimestamp(3, timestamp);
            statement.setLong(4, feedback.getUser().getId());
            statement.setLong(5, feedback.getProduct().getId());
            statement.executeUpdate();
        }
        return true;
    }

    @Override
    public boolean delete(Product id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<Feedback> getList(ResultSet result) throws SQLException {
        List<Feedback> feedbacks = new ArrayList<>();
        while (result.next()) {
            Long userId = result.getLong("user_id");
            User user = UserDAO.getInstance().findById(userId);
            Long productId = result.getLong("product_id");
            Product product = ProductDAO.getInstance().findById(productId);
            Integer rate = result.getInt("rate");
            String comment = result.getString("comment");
            Timestamp timestamp = result.getTimestamp("date");
            LocalDateTime localDateTime = timestamp.toLocalDateTime();
            feedbacks.add(new Feedback(user, product, rate, comment, localDateTime));
        }
        return feedbacks;
    }

    @Override
    public void setStatement(Feedback feedback, PreparedStatement statement) throws SQLException {

    }

    public Feedback findByUserAndProduct(User user, Product product) throws SQLException {
        List<Feedback> feedbacks = findByProduct(product);
        for (Feedback feedback : feedbacks) {
            if(Objects.equals(feedback.getUser().getId(), user.getId())) {
                return feedback;
            }
        }
        return null;
    }

    public double findAvgRate(Product product) throws SQLException {
        double avg = 0;
        try (PreparedStatement statement = dbConn.getConnection().prepareStatement(FIND_AVG_RATE_OF_PRODUCT)) {
            statement.setLong(1, product.getId());
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                avg = result.getDouble("avg");
            }
        }
        return avg;
    }
}
