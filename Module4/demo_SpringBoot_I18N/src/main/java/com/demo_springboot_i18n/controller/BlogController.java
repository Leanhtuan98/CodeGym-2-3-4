package com.demo_springboot_i18n.controller;


import com.demo_springboot_i18n.model.Blog;
import com.demo_springboot_i18n.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping
    public List<Blog> getAll(){
        return blogService.getAll();
    }

    @PostMapping
    public Blog create(@RequestBody Blog blog){
        return blogService.save(blog);
    }

    @GetMapping("/{id}")
    public Blog showEdit(@PathVariable int id){
        return blogService.findById(id);
    }

    @PutMapping("/{id}")
    public Blog edit(@RequestBody Blog blog){
        return blogService.save(blog);
    }

    @DeleteMapping("/{id}")
    public Blog delete(@PathVariable int id){
        return blogService.delete(id);
    }

}
