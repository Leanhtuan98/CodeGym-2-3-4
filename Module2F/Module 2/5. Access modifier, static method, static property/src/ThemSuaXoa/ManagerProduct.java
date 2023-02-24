package ThemSuaXoa;

public class ManagerProduct {
    Product[] products = new Product[0];

    public void show(){
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i].toString());

        }
    }
    public void add(Product product){
        Product[] newArr = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            newArr[i] = products[i];
        }
        newArr[newArr.length-1] = product;
        products = newArr;
    }
}
