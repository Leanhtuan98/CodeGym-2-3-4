package com.example.online_electronics_store.dao;

import com.example.online_electronics_store.model.Feedback;
import com.example.online_electronics_store.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IFeedbackDAO extends InterfaceDAO<Feedback, Product> {
    List<Feedback> findByProduct(Product product) throws SQLException;
}
