package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1,"NY Mạnh", "https://i.ibb.co/LzHGr6w/280120405-1055408911720137-8343618904438067534-n-result.jpg", true,500 ));
        products.add(new Product(2,"NY Nam", "https://i.seadn.io/gae/2lw8D4FOIXJvWn7U3p6noNIBZZqgDnt5ZbQ3OFzXOqa2Vka2cmEi3g9PKev-7ByjJ1iEsCQ6OeMY05b9dCfOG4NvniU3CU8gasla?auto=format&w=1000",false, 600 ));
    }

    public static Product findById(int id){
        for (Product p:products) {
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }
    public static int findIndexById(int id){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
}
