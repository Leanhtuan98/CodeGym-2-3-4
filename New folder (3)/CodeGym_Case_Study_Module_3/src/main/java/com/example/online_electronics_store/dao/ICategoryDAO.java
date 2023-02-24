package com.example.online_electronics_store.dao;

import com.example.online_electronics_store.model.Category;

import java.sql.SQLException;

public interface ICategoryDAO extends InterfaceDAO<Category, Long> {
    Category findByName(String name) throws SQLException;
}
