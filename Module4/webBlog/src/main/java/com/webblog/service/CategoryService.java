package com.webblog.service;

import com.webblog.model.Blog;
import com.webblog.repository.IBlogRepository;
import com.webblog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryService implements ICategoryService{
    @Autowired
    ICategoryRepository iCategoryRepository;
    @Override
    IBlogRepository iBlogRepository;

    public List<Blog> getAll(){
        return (List<Blog>) iBlogRepository.findAll();
    }

}
