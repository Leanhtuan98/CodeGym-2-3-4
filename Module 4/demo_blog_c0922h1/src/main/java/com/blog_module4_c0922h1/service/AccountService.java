package com.blog_module4_c0922h1.service;

import com.blog_module4_c0922h1.model.Account;
import com.blog_module4_c0922h1.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    IAccountRepo iAccountRepo;
    public Account checkLogin(String username, String password){
        return iAccountRepo.checkLogin(username,password);
    }
    public List<Account> findAll() {
        return (List<Account>) iAccountRepo.findAll();
    }
    public void save(Account account) {
        iAccountRepo.save(account);
    }
    public boolean checkTrungUsername(String username) {
        List<Account> accountList = findAll();
        for (Account account : accountList) {
            if (username.equals(account.getUsername())) {
                return false;
            }
        }
        return true;
    }

}
