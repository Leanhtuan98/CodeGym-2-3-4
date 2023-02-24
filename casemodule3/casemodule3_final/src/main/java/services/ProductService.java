package services;

import dao.ManProductDAO;

import dao.ProductDAO;
import models.Product;

import java.util.List;

public class ProductService {
    public static List<Product> getAllManProduct(){
        return ManProductDAO.getAllManCoat();
    }

    public static List<Product> getSearchProduct(String search){
        return ProductDAO.getSearchProduct(search);
    }
}
