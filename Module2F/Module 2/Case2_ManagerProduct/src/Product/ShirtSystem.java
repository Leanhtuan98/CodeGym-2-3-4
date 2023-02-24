package Product;

import Account.LoginManager;

import java.util.ArrayList;
import java.util.Scanner;

public class ShirtSystem {
    private static ArrayList<Size> sizes;

    static {
        sizes = new ArrayList<>();
        sizes.add(new Size("M"));
        sizes.add(new Size("L"));
        sizes.add(new Size("XL"));
        sizes.add(new Size("2XL"));
    }

    private static ArrayList<Brand> brands;

    static {
        brands = new ArrayList<>();
        brands.add(new Brand("Adidas"));
        brands.add(new Brand("Nike"));
        brands.add(new Brand("LV"));
        brands.add(new Brand("Gucci"));
    }

    public static void main(String[] args) {
        LoginManager loginManager = new LoginManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("                                         HOME PAGE                 ");
            System.out.println("[1]. Guest Page");
            System.out.println("[2]. Login");
            System.out.println("[3]. Register account");
            System.out.println("[0]. Exit");
            System.out.println("Enter your choice:");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice < 0 || choice >= 4) {
                    System.err.println("No selection, Please re-enter");
                }
                switch (choice) {
                    case 1:
                        menuGuest();
                        break;
                    case 2:
                        loginManager.loginAccount();
                        break;
                    case 3:
                        loginManager.registerAccount();
                        break;
                    case 0:
                        System.exit(0);
                }
            } catch (Exception e) {
                System.err.println("No selection, Please re-enter! ");
            }
        }
    }

    public static void menuGuest() {
        Scanner scanner = new Scanner(System.in);
        ShirtManager shirtManager = new ShirtManager();
        int choice1;
        do {
            try {
                System.out.println("                                  MENU GUEST                  ");
                System.out.println("[1]. View shirt.");
                System.out.println("[0]. Return.");
                System.out.println("Enter your choice:");
                choice1 = Integer.parseInt(scanner.nextLine());
                if (choice1 == 0) {
                    break;
                } else if (choice1 >= 2 || choice1 < 0) {
                    System.err.println("No selection, Please re-enter");
                }
                switch (choice1) {
                    case 1:
                        shirtManager.show();
                        break;
                }
            } catch (Exception e) {
                System.err.println("Please re-enter choice!");
            }
        } while (true);
    }

    public void menuAdmin() {
        Scanner scanner = new Scanner(System.in);
        ShirtManager shirtManager = new ShirtManager();
        int choice2;
        do {
            try {
                System.out.println("                                   MENU ADMIN                  ");
                System.out.println("[1]. View storage.");
                System.out.println("[2]. Add product.");
                System.out.println("[3]. Delete by id.");
                System.out.println("[4]. Update by id.");
                System.out.println("[5]. Find product by name.");
                System.out.println("[6]. Show account.");
                System.out.println("[0]. Return.");
                System.out.println("Enter your choice: ");
                choice2 = Integer.parseInt(scanner.nextLine());
                if (choice2 < 0 || choice2 >= 7) {
                    System.err.println("No selection, Please re-enter");
                } else {
                    switch (choice2) {
                        case 1:
                            shirtManager.show();
                            break;
                        case 2:
                            shirtManager.add(sizes, brands);
                            break;
                        case 3:
                            shirtManager.deleteById();
                            break;
                        case 4:
                            shirtManager.updateById();
                            break;
                        case 5:
                            shirtManager.findNameProduct();
                            break;
                        case 0:
                            return;
                            
                    }
                }

            } catch (Exception e) {
                System.err.println("Please re-enter choice: ");
            }
        } while (true);
    }

    public void menuUser() {
        Scanner scanner = new Scanner(System.in);
        ShirtManager shirtManager = new ShirtManager();
        int choice3;
        do {
            try {
                System.out.println("                                   MENU USER                 ");
                System.out.println("[1]. Buy Shirt");
                System.out.println("[2]. View Cart");
                System.out.println("[3]. View and pay Bill");
                System.out.println("[4]. Find name Product");
                System.out.println("[0]. Back");
                System.out.println("Enter your choice");
                choice3 = Integer.parseInt(scanner.nextLine());
                if (choice3 == 0) {
                    break;
                } else if (choice3 < 0 || choice3 >= 5) {
                    System.err.println("No choice! ");
                }
                switch (choice3) {
                    case 1:
                        shirtManager.show();
                        shirtManager.addProductByUser();
                        break;
                    case 2:
                        shirtManager.showCart();
                        break;
                    case 3:
                        shirtManager.payBill();
                        break;
                    case 4:
                        shirtManager.findNameProduct();
                        break;
                }

            } catch (Exception e) {
                System.err.println("No choice!");
            }
        } while (true);


    }
}
