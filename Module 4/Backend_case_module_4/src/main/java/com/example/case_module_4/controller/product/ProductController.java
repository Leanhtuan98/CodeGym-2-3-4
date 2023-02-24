package com.example.case_module_4.controller.product;

import com.example.case_module_4.model.Product;
import com.example.case_module_4.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/gender/{gender}")
    public ResponseEntity<Page<Product>> findAllProductByGender(@PathVariable String gender, @RequestParam(defaultValue = "0") int page) {
        return new ResponseEntity<>(productService.findAllProductByGender(gender, PageRequest.of(page, 4)), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable int id) {
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/category/{nameCategory}")
    public ResponseEntity<Page<Product>> findAllProductByCategory(@PathVariable String nameCategory, @RequestParam(defaultValue = "0") int page) {
        return new ResponseEntity<>(productService.findProductByCategory_NameCategory(nameCategory, PageRequest.of(page, 8)), HttpStatus.OK);
    }

    @GetMapping("/search/{stringSearch}")
    public ResponseEntity<Page<Product>> searchByName(@PathVariable String stringSearch, @RequestParam(defaultValue = "0") int page) {
        return new ResponseEntity<>(productService.searchByName(stringSearch, PageRequest.of(page,4)), HttpStatus.OK);
    }
}
