package models;

public class Product {
    private int idproduct;
    private String category;
    private String producttype;
    private String productname;
    private String color;
    private String size;
    private double price;
    private int amountproduct;
    private String imgproduct;

    public Product() {
    }

    public Product(int idproduct, String category, String productname, String color, String size, double price, int amountproduct, String imgproduct) {
        this.idproduct = idproduct;
        this.category = category;
        this.productname = productname;
        this.color = color;
        this.size = size;
        this.price = price;
        this.amountproduct = amountproduct;
        this.imgproduct = imgproduct;
    }

    public Product(int idproduct, String category, String producttype, String productname, String color, String size, double price, int amountproduct, String imgproduct) {
        this.idproduct = idproduct;
        this.category = category;
        this.producttype = producttype;
        this.productname = productname;
        this.color = color;
        this.size = size;
        this.price = price;
        this.amountproduct = amountproduct;
        this.imgproduct = imgproduct;
    }

    public String getProducttype() {
        return producttype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype;
    }

    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmountproduct() {
        return amountproduct;
    }

    public void setAmountproduct(int amountproduct) {
        this.amountproduct = amountproduct;
    }

    public String getImgproduct() {
        return imgproduct;
    }

    public void setImgproduct(String imgproduct) {
        this.imgproduct = imgproduct;
    }
}
