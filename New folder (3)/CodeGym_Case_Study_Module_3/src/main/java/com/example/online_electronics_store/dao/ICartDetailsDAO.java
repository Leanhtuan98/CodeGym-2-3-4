package com.example.online_electronics_store.dao;

import com.example.online_electronics_store.model.Cart;
import com.example.online_electronics_store.model.CartDetails;

import java.sql.SQLException;
import java.util.List;

public interface ICartDetailsDAO extends InterfaceDAO<CartDetails, Cart> {
    List<CartDetails> findByItemId(Cart cart) throws SQLException;
    boolean deleteByProduct(CartDetails cartDetails) throws SQLException;
}
