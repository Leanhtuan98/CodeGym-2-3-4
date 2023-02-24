package com.example.online_electronics_store.dao;

import com.example.online_electronics_store.model.CartDetails;
import com.example.online_electronics_store.model.Order;
import com.example.online_electronics_store.model.OrderDetails;

import java.sql.SQLException;
import java.util.List;

public interface IOrderDetailsDAO extends InterfaceDAO<OrderDetails, Order> {
    void insertFromCartDetails(List<CartDetails> cartDetailsList, Order order) throws SQLException;
    void cancelOrder(Order order) throws SQLException;
}
