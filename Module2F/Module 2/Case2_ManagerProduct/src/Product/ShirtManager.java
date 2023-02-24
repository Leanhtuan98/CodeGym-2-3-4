package Product;

import Account.User;
import IOTextFile.IOTextFile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ShirtManager implements Serializable {
    public ArrayList<Shirt> shirts;
    public ArrayList<User> users;
    public ArrayList<Shirt> shirtUser;
    public IOTextFile<Shirt> shirtIOTextFile = new IOTextFile<Shirt>();
    IOTextFile<User> userIOTextFile = new IOTextFile<User>();

    public ShirtManager() {
        shirts = shirtIOTextFile.readFile("src/File/Storage.txt");
        users = userIOTextFile.readFile("src/File/UserAccount.txt");
        shirtUser = shirtIOTextFile.readFile("src/File/CartUser.txt");
        resetStaticIndex();

    }

    public void resetStaticIndex() {
        if (!shirts.isEmpty()) {
            Shirt.INDEX = shirts.get(shirts.size() - 1).getId();

        }
    }


    public void add(ArrayList<Size> sizes, ArrayList<Brand> brandArrayList) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter name: ");
            String name = scanner.nextLine();
            System.out.println("Enter price: ");
            Double price = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter Size: ");
            Size size = getSizeByIndex(sizes, scanner);
            System.out.println("Enter brand");
            Brand brand = getBrandByIndex(brandArrayList, scanner);
            System.out.println(" Successfully add!");
            shirts.add(new Shirt(name, price, quantity, size, brand));
            shirtIOTextFile.writeFile(shirts, "src/File/Storage.txt");
            resetStaticIndex();


        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteById() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the id you want to delete:  ");
            int id = Integer.parseInt(scanner.nextLine());
            int index = findIndexById(id);
            if (index < 0 || index > shirts.size()) {
                System.err.println("No ID");
            } else {
                shirts.remove(index);
                System.out.println("Successful delete");
                shirtIOTextFile.writeFile(shirts, "src/File/Storage.txt");
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());

        }
    }

    public void updateById() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter Id want to Update");
            int id = Integer.parseInt(scanner.nextLine());
            int index = findIndexById(id);
            if (index < 0 || index > shirts.size()) {
                System.err.println("No Id");
            } else {
                System.out.println("Enter new name: ");
                String name = scanner.nextLine();
                shirts.get(index).setName(name);

                System.out.println("Enter new price: ");
                Double price = Double.parseDouble(scanner.nextLine());
                shirts.get(index).setPrice(price);

                System.out.println("Enter new quantity: ");
                int quantity = Integer.parseInt((scanner.nextLine()));
                shirts.get(index).setQuantity(quantity);

                System.out.println("Enter new size: ");
                String size1 = scanner.nextLine();
                Size size = new Size(size1);
                shirts.get(index).setSize(size);

                System.out.println("Enter new brand: ");
                String brand1 = scanner.nextLine();
                Brand brand = new Brand(brand1);
                shirts.get(index).setBrand(brand);

                System.out.println("Successful Update");
                shirtIOTextFile.writeFile(shirts, "src/File/Storage.txt");

            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


    private Size getSizeByIndex(ArrayList<Size> sizes, Scanner scanner) {

        for (int i = 0; i < sizes.size(); i++) {
            System.out.println((i + 1) + "." + sizes.get(i).getSize());
        }
        System.err.println("0. No choice!");
        int choice;
        try {
            do {
                System.out.println("Enter your choice: ");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 0) {
                    System.out.println("Nothing!");
                }
                if (choice > 0 && choice <= sizes.size()) {
                    return sizes.get(choice - 1);
                }
                System.out.println("Please re-enter your selection!");
            } while (choice < 0 || choice > sizes.size());
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private Brand getBrandByIndex(ArrayList<Brand> brands, Scanner scanner) {
        for (int i = 0; i < brands.size(); i++) {
            System.out.println((i + 1) + "." + brands.get(i).getName());
        }
        System.err.println("0. No choice!");
        int choice1;
        try {
            do {
                System.out.println("Enter your choice: ");
                choice1 = Integer.parseInt(scanner.nextLine());
                if (choice1 == 0) {
                    System.out.println("Nothing!");
                }
                if (choice1 > 0 && choice1 <= brands.size()) {
                    return brands.get(choice1 - 1);
                }
                System.out.println("Please re-enter your selection!");
            } while (choice1 < 0 || choice1 > brands.size());
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    public void show() {
        shirts = shirtIOTextFile.readFile("src/File/Storage.txt");
        if (shirts.isEmpty()) {
            System.err.println("No shirt!");
        } else {
            System.out.printf("%-10s%-20s%-15s%-15s%-20s%s", "ID", "Name", "Price", "Quantity", "Size", "Brand\n");
            for (int i = 0; i < shirts.size(); i++) {
                shirts.get(i).show();
            }
        }
    }


    public int findIndexById(int id) {
        for (int i = 0; i < shirts.size(); i++) {
            if (shirts.get(i).getId() == id) {
                return i;
            }

        }
        return -1;
    }

    public void findNameProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name you want search: ");
        String search = scanner.nextLine();
        System.out.println("List search " + search + ": ");
        for (Shirt list : shirts) {
            if (list.getName().contains(search)) {
                System.out.println(list);
            }
        }
    }

    public void addProductByUser() {
        shirtIOTextFile.readFile("src/File/Storage.txt");
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter id shirt you want buy: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter quantity you want buy: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            for (Shirt shirt : shirts) {
                if (shirt.getId() == id) {
                    if (shirt.getQuantity() > quantity) {
                        shirt.setQuantity(shirt.getQuantity() - quantity);
                        shirtIOTextFile.writeFile(shirts, "src/File/Storage.txt");
                        shirtUser.add(shirt);
                        for (Shirt shirt1 : shirtUser) {
                            shirt1.setQuantity(quantity);
                        }
                        shirtIOTextFile.writeFile(shirtUser, "src/File/CartUser.txt");
                        System.out.println("Success Buy! ");
                        break;
                    } else {
                        System.err.println("Insufficient quantities ");
                    }

                }
            }


        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void showCart() {
        shirtIOTextFile.readFile("src/File/CartUser.txt");
        if (shirtUser.isEmpty()) {
            System.err.println("No Shirt!");
        } else {
            System.out.printf("%-10s%-20s%-15s%-15s%-20s%s", "ID", "Name", "Price", "Quantity", "Size", "Brand\n");
            for (Shirt shirtBuy : shirtUser) {
                shirtBuy.show();
            }
        }
    }

    public void payBill() {
        showCart();
        Double sum = 0.0;
        for (Shirt shirtBuy : shirtUser) {
            sum += shirtBuy.getPrice();
        }
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println( "Total:                               " + sum + "USD"  );
        shirtUser.clear();
        shirtIOTextFile.writeFile(shirtUser, "src/File/CartUser.txt");

    }


}

