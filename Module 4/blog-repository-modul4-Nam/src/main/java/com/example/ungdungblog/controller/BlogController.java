package com.example.ungdungblog.controller;

import com.example.ungdungblog.model.Blog;
import com.example.ungdungblog.model.Category;
import com.example.ungdungblog.repository.IBlogRepo;
import com.example.ungdungblog.service.BlogService;
import com.example.ungdungblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    private IBlogRepo iBlogRepo;

    @ModelAttribute("category")
    public List<Category> categoryList() {
        return categoryService.getAll();
    }

    @GetMapping("/blogs")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("showBlog");
        modelAndView.addObject("blogs", blogService.getAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate(@ModelAttribute("category") Category category) {
        ModelAndView modelAndView = new ModelAndView("create");
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Blog blog, @RequestParam("idCategory") Integer idCategory, @RequestParam MultipartFile upImg) {
        ModelAndView modelAndView;
        String nameFile = upImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(upImg.getBytes(), new File("C:\\Users\\Wind\\Desktop\\Module 4\\blog-repository-modul4-Nam\\src\\main\\webapp\\WEB-INF\\image\\"+nameFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
        blog.setImg("/image/"+nameFile);
        blog.setCategory(categoryService.findById(idCategory));
        blogService.save(blog);
        modelAndView = new ModelAndView("redirect:/blogs");
        return modelAndView;
    }
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam int id) {
        blogService.delete(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/blogs");
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("blog",blogService.findById(id));
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute Blog blog,@RequestParam MultipartFile upImg ) {
        ModelAndView modelAndView = new ModelAndView("redirect:/blogs");
        if(!upImg.isEmpty()) {
            String nameFile = upImg.getOriginalFilename();
            try {
                FileCopyUtils.copy(upImg.getBytes(),new File("C:\\Users\\Wind\\Desktop\\Module 4\\blog-repository-modul4-Nam\\src\\main\\webapp\\WEB-INF\\image\\"+nameFile));
            } catch (Exception e) {
                e.printStackTrace();
            }
            blog.setImg("/image/"+nameFile);
        }
        blogService.save(blog);
        return modelAndView;
    }
}
