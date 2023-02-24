package com.webblog.controller;

import com.webblog.model.Blog;
import com.webblog.service.BlogService;
import com.webblog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
public class BlogController {
    @Autowired
    IBlogService iBlogService;

    @GetMapping("/blog")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("showBlog");
        modelAndView.addObject("blogs", iBlogService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        return modelAndView;
    }
    @PostMapping("/create")
    public String create(@ModelAttribute(value = "blog") Blog blog, BindingResult bindingResult, @RequestParam MultipartFile upImg) {
//        validate_trung_name.validate(student, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "create";
        }
        String nameFile = upImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(upImg.getBytes(), new File("C:/Users/Wind/Desktop/Module4/webBlog/src/main/webapp/WEB-INF/img/" + nameFile));
            blog.setImg("/img/" + nameFile);
            iBlogService.save(blog);

        } catch (IOException e) {
            blog.setImg("/img/abc.jpeg");
            iBlogService.save(blog);
            e.printStackTrace();
        }
        return "redirect:/blogs";
    }
}

