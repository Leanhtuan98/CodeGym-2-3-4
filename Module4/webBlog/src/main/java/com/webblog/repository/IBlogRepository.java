package com.webblog.repository;

import com.webblog.model.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IBlogRepository extends PagingAndSortingRepository<Blog,Long> {

}
