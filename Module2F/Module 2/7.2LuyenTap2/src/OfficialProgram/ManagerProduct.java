package OfficialProgram;

import java.util.Scanner;

public class ManagerProduct {
    Product[] products = new Product[0];

    public void show() {
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i].show());
        }
    }

    public void add(Product product) {
        Product[] newArr = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            newArr[i] = products[i];
        }
        newArr[newArr.length - 1] = product;
        products = newArr;
    }

    public Product creatProduct(){
        // Tạo scanner để nhập từ bàn phím.
        Scanner scanner = new Scanner(System.in);


        System.out.println(" Nhập tên của sản phẩm");
        String name = scanner.nextLine();
        System.out.println("Nhập ảnh của sản phẩm");
        String img = scanner.nextLine();
        System.out.println("Nhập giá của sản phẩm");
        double price = Double.parseDouble(scanner.nextLine());
        Product product = new Product(name,img,price);
        return product;
    }
    public void edit(int index, Product product) {
        if (index >= 0 && index < products.length) {
            products[index] = product;
        }
    }
    public void delete(int index) {
        if(index>= 0 && index < products.length ) {
            Product [] newArr = new Product[products.length -1];
            for (int i = 0; i < newArr.length; i++) {
                if (i < index) {
                    newArr[i] = products[i];
                } else {
                    newArr[i] = products[i+1];
                }
            }
            products = newArr;
        }
    }
}
