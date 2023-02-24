package com.demo_manageremployee_springboot.repository;

import com.demo_manageremployee_springboot.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IEmployeeRepo extends PagingAndSortingRepository<Employee,Long> {
    @Query(nativeQuery = true, value = "select count(id) from employee")
    Long countEmployee();

    // tên,ảnh,tên loại product
//    @Query(nativeQuery = true, value = "select product.name as namep, img, category.name as namec from product join category on product.category_id = category.id")
//    List<Demo> getDemo();
}
