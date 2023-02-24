package com.example.case_module_4.service;

import com.example.case_module_4.model.Product;
import com.example.case_module_4.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    IProductRepo iProductRepo;

   public Page<Product> findAllProductByGender(String gender, Pageable pageable) {
       return iProductRepo.findProductByCategory_Gender(gender, pageable);
   }

   public List<Product> list(){
       return (List<Product>) iProductRepo.findAll();
   }


    public Product findById(int id) {
      return iProductRepo.findById(id).get();
    }

    public Page<Product> findProductByCategory_NameCategory(String nameCategory, Pageable pageable) {
        return iProductRepo.findProductByCategory_NameCategory(nameCategory, pageable);
    }

    public Page<Product> searchByName(String stringSearch, Pageable pageable) {
       return iProductRepo.findAllByNameProductContaining(stringSearch, pageable);
    }

}
