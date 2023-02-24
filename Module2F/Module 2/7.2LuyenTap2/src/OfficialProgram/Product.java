package OfficialProgram;

import java.util.Scanner;

public class Product {
    private String  name;
    private String img;
    private double price;


    public Product() {
    }

    public Product(String name, String img,double price) {
        this.name = name;
        this.img = img;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String show() {
        return this.name + " - " + this.img + " - " + this.price;
    }
}
