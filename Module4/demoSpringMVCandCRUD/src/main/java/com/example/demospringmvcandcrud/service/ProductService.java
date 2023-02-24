package com.example.demospringmvcandcrud.service;

import com.example.demospringmvcandcrud.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public static List<Product> products = new ArrayList<>();

    static  {
        products.add(new Product(1,"BimBim", 10));
        products.add(new Product(2,"Keo",20));
    }

    public static void delete(int id){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id){
                products.remove(i);
            }
        }
    }

    public static Product findIndexById(int id){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id){
                return products.get(i);
            }
        }
        return null;
    }

    public static List<Product> search(String str){
        List<Product> listSearch=new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getName().toUpperCase().contains(str.toUpperCase())){
                listSearch.add(products.get(i));
            }
        }
        return listSearch ;
    }

//    public static void edit(int id){
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getId() == id){
//                products.g
//            }
//        }
//    }
}
