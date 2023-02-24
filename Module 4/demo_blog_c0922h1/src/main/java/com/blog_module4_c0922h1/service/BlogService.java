package com.blog_module4_c0922h1.service;

import com.blog_module4_c0922h1.model.Blog;
import com.blog_module4_c0922h1.repository.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
public class BlogService {
    @Autowired
    IBlogRepo iBlogRepository;

    public Page<Blog> findAll(Pageable pageable){
        return iBlogRepository.findAll(pageable);
    }

    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    public void delete(int id) {
        iBlogRepository.deleteById(id);
    }

    public Optional<Blog> findById(int id) {
        return iBlogRepository.findById(id);
    }
}
