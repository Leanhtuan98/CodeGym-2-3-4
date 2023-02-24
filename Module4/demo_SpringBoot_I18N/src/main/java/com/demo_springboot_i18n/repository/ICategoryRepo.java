package com.demo_springboot_i18n.repository;


import com.demo_springboot_i18n.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICategoryRepo extends PagingAndSortingRepository<Category, Integer> {
}
