package com.example.online_electronics_store.dao;

import com.example.online_electronics_store.model.Cart;
import com.example.online_electronics_store.model.User;

import java.sql.SQLException;

public interface ICartDAO extends InterfaceDAO<Cart, Long> {
    Cart findByUser(User user) throws SQLException;
}
