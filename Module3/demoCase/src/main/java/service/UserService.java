package service;

import dao.UserDAO;
import models.Account;

public class UserService {
    UserDAO userDAO = new UserDAO();

    public Account checkLogin(String username, String password){
        return userDAO.checkLogin(username,password);
    }
}