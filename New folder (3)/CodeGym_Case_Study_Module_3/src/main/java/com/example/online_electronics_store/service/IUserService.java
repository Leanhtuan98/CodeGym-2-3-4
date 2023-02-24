package com.example.online_electronics_store.service;

import com.example.online_electronics_store.model.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public interface IUserService extends IService<User> {
    User loginCheck(HttpServletRequest request) throws SQLException;
}
