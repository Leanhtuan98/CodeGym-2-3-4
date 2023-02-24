package dao;

import models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductWomenDAO {
    static Connection connection = ConnectionMySql.getConnection();
    public static List<Product> getAllWomenShirt() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE product.category='shirts'and product.size='s'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("idproduct");
                String category = resultSet.getString("category");
                String productname=resultSet.getString("productname");
                String color = resultSet.getString("color");
                String size = resultSet.getString("size");
                double price = resultSet.getDouble("price");
                int amountproduct = resultSet.getInt("amountproduct");
                String imgproduct = resultSet.getString("imgproduct");

                products.add(new Product(id, category,productname,color,size,price,amountproduct,imgproduct));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return products;
    }
    public static List<Product> getAllWomenCoat() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE product.category='coat' and product.producttype='women' and product.size='s'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int idproduct = resultSet.getInt("idproduct");
                String category = resultSet.getString("category");
                String productname=resultSet.getString("productname");
                String color = resultSet.getString("color");
                String size = resultSet.getString("size");
                double price = resultSet.getDouble("price");
                int amountproduct = resultSet.getInt("amountproduct");
                String imgproduct = resultSet.getString("imgproduct");

                products.add(new Product(idproduct, category,productname,color,size,price,amountproduct,imgproduct));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return products;
    }
    public static List<Product> getAllWomenJeans() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE product.category='jeans' and product.size='s'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("idproduct");
                String category = resultSet.getString("category");
                String productname=resultSet.getString("productname");
                String color = resultSet.getString("color");
                String size = resultSet.getString("size");
                double price = resultSet.getDouble("price");
                int amountproduct = resultSet.getInt("amountproduct");
                String imgproduct = resultSet.getString("imgproduct");

                products.add(new Product(id, category,productname,color,size,price,amountproduct,imgproduct));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return products;
    }
    public static List<Product> getAllWomenDress() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE product.category='dress' and product.size='s'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("idproduct");
                String category = resultSet.getString("category");
                String productname=resultSet.getString("productname");
                String color = resultSet.getString("color");
                String size = resultSet.getString("size");
                double price = resultSet.getDouble("price");
                int amountproduct = resultSet.getInt("amountproduct");
                String imgproduct = resultSet.getString("imgproduct");

                products.add(new Product(id, category,productname,color,size,price,amountproduct,imgproduct));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return products;
    }
    public static boolean save(Product product) {
        String sql = "insert into product value (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,product.getIdproduct());
            preparedStatement.setString(2, product.getCategory());
            preparedStatement.setString(3, product.getProductname());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getSize());
            preparedStatement.setDouble(6, product.getPrice());
            preparedStatement.setInt(7,product.getAmountproduct());
            preparedStatement.setString(8, product.getImgproduct());
            return preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
