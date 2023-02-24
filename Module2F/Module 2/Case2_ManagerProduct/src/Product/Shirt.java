package Product;

import java.io.Serializable;

public class Shirt implements Serializable {
    public static int INDEX = Integer.valueOf(0);
    private int id;
    private String name;
    private Double price;
    private int quantity;
    private Size size;
    private Brand brand;


    public Shirt() {
    }


    public Shirt(String name, Double price, int quantity, Size size, Brand brand) {
        this.id = Integer.valueOf(++INDEX);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.size = size;
        this.brand = brand;
    }

    public static int getINDEX() {
        return INDEX;
    }

    public static void setINDEX(int INDEX) {
        Shirt.INDEX = INDEX;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price * quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        if (size != null && brand != null) {
            return "Shirt{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    ", quantity=" + quantity +
                    ", size=" + size.getSize() +
                    ", brand=" + brand.getName() +
                    '}';
        } else {
            return "Shirt{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    ", quantity=" + quantity +
                    ", size  = nothing" +
                    ", brand = nothing" +
                    '}';

        }
    }

    public void show() {
        if (size != null && brand != null) {
            System.out.printf("%-10d%-20s%-15.0f%-15d%-20s%-16s \n", id, name, price, quantity, size.getSize(), brand.getName());
        } else {
            System.out.printf("%-10d%-20s%-15.0f%-15d%-20s%-16s \n", id, name, price, quantity, "nothing", "nothing" );
        }
    }
}


