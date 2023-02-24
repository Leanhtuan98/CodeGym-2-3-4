package com.example.online_electronics_store.service.impl;

import com.example.online_electronics_store.dao.impl.UserDAO;
import com.example.online_electronics_store.model.User;
import com.example.online_electronics_store.service.IUserService;
import com.example.online_electronics_store.service.Verify;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService {
    private static UserService instance;

    private UserService() {

    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    @Override
    public boolean create(HttpServletRequest request) throws ServletException, IOException, SQLException {
        User user = getObject(request);
        if (Verify.getInstance().verifyRegister(user)) {
            UserDAO.getInstance().insert(user);
            return true;
        }
        return false;
    }

    @Override
    public void render(HttpServletRequest request, List<User> lists)  {
        request.setAttribute("user", lists);
    }

    @Override
    public void update(HttpServletRequest request) throws SQLException {
        User user = getObject(request);
        Long id = Long.parseLong(request.getParameter("id"));
        UserDAO.getInstance().update(id, user);
    }

    @Override
    public void delete(HttpServletRequest request) {

    }

    @Override
    public User getObject(HttpServletRequest request) throws SQLException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phone-number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        List<User> users = UserDAO.getInstance().findAll();
        Long id = users.get(users.size() - 1).getId() + 1;
        return new User(id, username, password, phoneNumber, email, address);
    }

    @Override
    public User loginCheck(HttpServletRequest request) throws SQLException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        List<User> users = UserDAO.getInstance().findAll();
        for (User user : users) {
            if ((user.getUsername().equals(account) || user.getEmail().equals(account))
                && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public boolean updateAcc(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        Long id = u.getId();
        String password = request.getParameter("new_password");
        String phoneNumber = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        User user = new User(password, phoneNumber, email, address);
        if (Verify.getInstance().verifyUpdate(user, id)) {
            UserDAO.getInstance().update(id, user);
            return true;
        }
        return false;
    }
}
