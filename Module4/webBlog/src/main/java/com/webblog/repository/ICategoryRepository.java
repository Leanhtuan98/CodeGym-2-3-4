package com.webblog.repository;

import com.webblog.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepository extends CrudRepository<Category,Long> {

}
