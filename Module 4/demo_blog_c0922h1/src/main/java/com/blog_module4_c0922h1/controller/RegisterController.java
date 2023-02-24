package com.blog_module4_c0922h1.controller;

import com.blog_module4_c0922h1.model.Account;
import com.blog_module4_c0922h1.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Controller
public class RegisterController {
    @Autowired
    AccountService accountService;

    @GetMapping(value = "/register")
    public ModelAndView showRegister() {
        ModelAndView modelAndView = new ModelAndView("register");
        return modelAndView;
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Account account, @RequestParam MultipartFile upAvatar) {
        if (!accountService.checkTrungUsername(account.getUsername())) {
            return "redirect: /register";
        } else {
            String nameFile = upAvatar.getOriginalFilename();
            try {
                FileCopyUtils.copy(upAvatar.getBytes(), new File("C:\\Users\\Wind\\Desktop\\Module 4\\demo_blog_c0922h1\\src\\main\\webapp\\WEB-INF\\img\\" + nameFile));
            } catch (Exception e) {
                e.printStackTrace();
            }
            account.setAvatar("/img/" + nameFile);
            accountService.save(account);
            return "redirect: /login";
        }
    }
}

