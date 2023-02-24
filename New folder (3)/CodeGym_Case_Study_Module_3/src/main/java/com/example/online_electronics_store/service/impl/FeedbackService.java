package com.example.online_electronics_store.service.impl;

import com.example.online_electronics_store.dao.impl.FeedbackDAO;
import com.example.online_electronics_store.dao.impl.ProductDAO;
import com.example.online_electronics_store.model.Feedback;
import com.example.online_electronics_store.model.Product;
import com.example.online_electronics_store.model.User;
import com.example.online_electronics_store.service.IFeedbackService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class FeedbackService implements IFeedbackService {
    private static FeedbackService instance;

    private FeedbackService() {

    }

    public static FeedbackService getInstance() {
        if (instance == null) {
            instance = new FeedbackService();
        }
        return instance;
    }

    @Override
    public boolean create(HttpServletRequest request) throws ServletException, IOException, SQLException, ClassNotFoundException {
        return true;
    }

    @Override
    public void render(HttpServletRequest request, List<Feedback> lists) throws SQLException, ClassNotFoundException {

    }

    @Override
    public void update(HttpServletRequest request) throws SQLException {

    }

    @Override
    public void delete(HttpServletRequest request) {

    }

    @Override
    public Feedback getObject(HttpServletRequest request) throws SQLException {
        return null;
    }

    public Long feedback(HttpServletRequest request) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String comment = request.getParameter("comment");
        int rate = Integer.parseInt(request.getParameter("rate"));
        Long id = Long.parseLong(request.getParameter("id"));
        Product product = ProductDAO.getInstance().findById(id);
        LocalDateTime dateTime = LocalDateTime.now();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Feedback feedback = new Feedback(user, product, rate, comment, dateTime);
        List<Feedback> feedbacks = FeedbackDAO.getInstance().findByProduct(product);
        if (feedbacks.isEmpty()) {
            FeedbackDAO.getInstance().insert(feedback);
            return id;
        }
        for (Feedback f : feedbacks) {
            if (Objects.equals(f.getUser().getId(), user.getId())) {
                FeedbackDAO.getInstance().update(product, feedback);
                return id;
            }
        }
        FeedbackDAO.getInstance().insert(feedback);
        return id;
    }
}
