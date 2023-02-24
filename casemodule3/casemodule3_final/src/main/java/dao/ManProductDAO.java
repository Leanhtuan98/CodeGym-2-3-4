package dao;


import models.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ManProductDAO {
    static Connection connection = ConnectionMySql.getConnection();
    public static List<Product> getAllManShirt() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE product.category='shirt' AND product.size='s' and product.producttype='men' ";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("idproduct");
                String category = resultSet.getString("category");
                String productname = resultSet.getString("productname");
                String color = resultSet.getString("color");
                String size = resultSet.getString("size");
                double price = resultSet.getDouble("price");
                int amountproduct = resultSet.getInt("amountproduct");
                String imgproduct = resultSet.getString("imgproduct");
                products.add(new Product(id,category,productname,color,size,price,amountproduct,imgproduct));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return products;
    }
    public static List<Product> getAllManCoat() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE product.category='coat' AND product.size='s' and product.producttype='men' ";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("idproduct");
                String category = resultSet.getString("category");
                String productname = resultSet.getString("productname");
                String color = resultSet.getString("color");
                String size = resultSet.getString("size");
                double price = resultSet.getDouble("price");
                int amountproduct = resultSet.getInt("amountproduct");
                String imgproduct = resultSet.getString("imgproduct");
                products.add(new Product(id,category,productname,color,size,price,amountproduct,imgproduct));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return products;
    }
    public static List<Product> getAllManJeans() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE product.category='jeans' AND product.size='s' and product.producttype='men' ";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("idproduct");
                String category = resultSet.getString("category");
                String productname = resultSet.getString("productname");
                String color = resultSet.getString("color");
                String size = resultSet.getString("size");
                double price = resultSet.getDouble("price");
                int amountproduct = resultSet.getInt("amountproduct");
                String imgproduct = resultSet.getString("imgproduct");
                products.add(new Product(id,category,productname,color,size,price,amountproduct,imgproduct));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return products;
    }
    public static List<Product> getAllManShort() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE product.category='short' AND product.size='s' and product.producttype='men' ";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("idproduct");
                String category = resultSet.getString("category");
                String productname = resultSet.getString("productname");
                String color = resultSet.getString("color");
                String size = resultSet.getString("size");
                double price = resultSet.getDouble("price");
                int amountproduct = resultSet.getInt("amountproduct");
                String imgproduct = resultSet.getString("imgproduct");
                products.add(new Product(id,category,productname,color,size,price,amountproduct,imgproduct));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return products;
    }
    public static List<Product> getSearchManShort() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE product.productname LIKE"+"%"+"short"+"%" ;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("idproduct");
                String category = resultSet.getString("category");
                String productname = resultSet.getString("productname");
                String color = resultSet.getString("color");
                String size = resultSet.getString("size");
                double price = resultSet.getDouble("price");
                int amountproduct = resultSet.getInt("amountproduct");
                String imgproduct = resultSet.getString("imgproduct");
                products.add(new Product(id,category,productname,color,size,price,amountproduct,imgproduct));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return products;
    }


}
