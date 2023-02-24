package com.demo_springboot_i18n.repository;


import com.demo_springboot_i18n.model.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IBlogRepo extends PagingAndSortingRepository<Blog, Integer> {
}
