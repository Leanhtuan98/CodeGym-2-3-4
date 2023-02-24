package com.example.case_module_4.repository;

import com.example.case_module_4.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepo extends PagingAndSortingRepository<Product, Integer > {
//    @Query(value = "select product.* from product inner join category on product.category_id_category=category.id_category where category.gender like 'men';", nativeQuery = true )
//    Page<Product> findProductForMen(Pageable pageable);

    Page<Product> findProductByCategory_Gender(String gender, Pageable pageable);
    Page<Product> findProductByCategory_NameCategory(String nameCategory, Pageable pageable);

    Page<Product> findProductByNameProductContaining(String stringSearch, Pageable pageable);

    Page<Product> findAllByNameProductContaining(String stringSearch, Pageable pageable);
}
