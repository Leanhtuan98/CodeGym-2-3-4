package com.webblog.service;

import com.webblog.model.Blog;
import com.webblog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository iBlogRepository;

    public List<Blog> getAll(){
        return (List<Blog>) iBlogRepository.findAll();
    }

    @Override
    public List<Blog> findAll() {
        return (List<Blog>) iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);

    }

    @Override
    public void delete(long id) {
        iBlogRepository.deleteById(id);

    }

    @Override
    public Optional<Blog> findById(long id) {
        return iBlogRepository.findById(id);
    }
}
