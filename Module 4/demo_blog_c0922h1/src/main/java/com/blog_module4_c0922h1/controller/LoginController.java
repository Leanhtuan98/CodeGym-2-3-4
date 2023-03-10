package com.blog_module4_c0922h1.controller;

import com.blog_module4_c0922h1.model.Account;
import com.blog_module4_c0922h1.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    AccountService accountService;

    @Autowired
    HttpSession httpSession;

    @GetMapping("/login")
    public String showLogin(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password){
        Account account = accountService.checkLogin(username,password);
        if (account == null){
            return "redirect:/login";
        }else {
            httpSession.setAttribute("account", account);
            return "redirect:/blogs";
        }
    }
}

