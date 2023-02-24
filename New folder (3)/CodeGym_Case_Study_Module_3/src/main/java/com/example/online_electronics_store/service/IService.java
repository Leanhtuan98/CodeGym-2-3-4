package com.example.online_electronics_store.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IService<E> {
    boolean create(HttpServletRequest request) throws ServletException, IOException, SQLException, ClassNotFoundException;
    void render(HttpServletRequest request, List<E> lists) throws SQLException, ClassNotFoundException;
    void update(HttpServletRequest request) throws SQLException;
    void delete(HttpServletRequest request);
    E getObject(HttpServletRequest request) throws SQLException;
}
