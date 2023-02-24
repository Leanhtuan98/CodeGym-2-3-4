package com.demo_springboot_i18n.service;


import com.demo_websevice_c0922h1.model.Blog;
import com.demo_websevice_c0922h1.repository.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlogService {
    @Autowired
    IBlogRepo iBlogRepo;

    public List<Blog> getAll() {
        return (List<Blog>) iBlogRepo.findAll();
    }

    public Blog save(Blog blog) {
        return iBlogRepo.save(blog);
    }

    public Blog delete(int id) {
        Blog blog = findById(id);
        iBlogRepo.deleteById(id);
        return blog;
    }

    public Blog findById(int id) {
        return iBlogRepo.findById(id).get();
    }

}
