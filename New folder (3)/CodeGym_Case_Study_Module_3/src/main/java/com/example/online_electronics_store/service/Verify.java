package com.example.online_electronics_store.service;

import com.example.online_electronics_store.dao.impl.UserDAO;
import com.example.online_electronics_store.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class Verify {
    private static Verify instance;

    private Verify() {

    }

    public static Verify getInstance() {
        if (instance == null) {
            instance = new Verify();
        }
        return instance;
    }

    public boolean verifyRegister(User user) throws SQLException {
        List<User> users = UserDAO.getInstance().findAll();
        for (User u : users) {
            if (u.getUsername().equals(user.getUsername()) || u.getEmail().equals(user.getEmail()) ||
                u.getPhoneNumber().equals(user.getPhoneNumber())) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyUpdate(User user, Long id) throws SQLException {
        List<User> users = UserDAO.getInstance().findAll();
        for (User u : users) {
            if (Objects.equals(u.getId(), id)) {
                continue;
            }
            if (u.getEmail().equals(user.getEmail()) || u.getPhoneNumber().equals(user.getPhoneNumber())) {
                return false;
            }
        }
        return true;
    }
}
