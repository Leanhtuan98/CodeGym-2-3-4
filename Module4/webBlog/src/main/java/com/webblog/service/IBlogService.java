package com.webblog.service;

import com.webblog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {

    public List<Blog> findAll();
    public void save(Blog blog);
    public void delete(long id);
    public Optional<Blog> findById(long id);
}
