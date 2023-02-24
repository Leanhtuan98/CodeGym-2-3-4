package services;

import dao.ProductWomenDAO;
import models.Product;

import java.util.List;

public class ProductWomenService {
    public static List<Product> getAllWomenShirt() {
        return ProductWomenDAO.getAllWomenShirt();
    }

    public static List<Product> getAllWomenCoat() {
        return ProductWomenDAO.getAllWomenCoat();
    }

    public static List<Product> getAllWomenJeans() {
        return ProductWomenDAO.getAllWomenJeans();
    }
    public static List<Product> getAllWomenDress() {
        return ProductWomenDAO.getAllWomenDress();
    }
}
