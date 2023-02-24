package Account;

import IOTextFile.IOTextFile;
import Product.ShirtSystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class LoginManager implements Serializable {

    IOTextFile<User> ioTextFile = new IOTextFile<User>();
    public ArrayList<User> users;
    ShirtSystem shirtSystem = new ShirtSystem();


    public LoginManager() {
        users = ioTextFile.readFile("src/File/Account.txt");
        User admin = new User("tuan", "123");
        admin.setRole1(new Role("ADMIN"));
        users.add(admin);
        ioTextFile.writeFile(users, "src/File/Account.txt");

    }

    public String getUsername() {
        Scanner scanner = new Scanner(System.in);
        String username = "";
        while (true) {
            String string = "Enter Username: ";
            System.out.println(string);
            username = scanner.nextLine();
            boolean username1 = Pattern.matches("[0-9a-zA-Z]{6,31}", username);
            if (username1) break;
            else {
                System.err.println("Wrong format!");
                System.out.print("\nRe-Enter!");
                scanner.nextLine();
            }
        }
        return username;
    }

    public String getPassword() {
        Scanner scanner = new Scanner(System.in);
        String password = "";
        while (true) {
            String string = "Enter Password:";
            System.out.println(string);
            password = scanner.nextLine();
            boolean password1 = Pattern.matches("[0-9a-zA-Z]{6,31}", password);
            boolean password2 = Pattern.matches("[0-9a-zA-Z]*[0-9]+[0-9a-zA-Z]*", password);
            boolean password3 = Pattern.matches("[0-9a-zA-Z]*[a-zA-Z]+[0-9a-zA-Z]*", password);
            if (password1 && password2 && password3) break;
            else {
                System.err.println("Wrong format!");
                System.out.print("\nRe-Enter!");
                scanner.nextLine();
            }
        }
        return password;
    }

    public void registerAccount() {
//        String username;
//        do{
//            System.out.println("Enter new username: ");
//            username = scanner.nextLine();
//            Pattern pattern = Pattern.compile("^[0-9A-Za-z]{8,16}$");
//            boolean flag = false;
//            for (User user : users){
//                if (pattern.matcher(username).find() ){
//                    if (!user.getUserName().equals(username)){
//                        System.out.println("Ok!");
//                        flag = true;
//                        break;
//                    } else {
//                        System.out.println("Username already exists !");
//                    }
//                }
//            }
//            if (!flag) {
//                System.out.println("Account not hop le!");
//                break;
//            }
//        }while (true);
//
//        String password;
//        do {
//            System.out.println("Enter new password: ");
//            password = scanner.nextLine();
//            Pattern pattern1 = Pattern.compile("^[0-9A-Za-z]{8,16}$");
//            if (pattern1.matcher(password).find()) {
//                System.out.println("OK!");
//                break;
//            } else {
//                System.out.println("Invalid password, please input again");
//            }
//
//        } while (true);
        int index;
        String username;
        do {
            index = -1;
            username = getUsername();
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUserName().equals(username))
                    index = i;
            }
            if (index != -1) System.err.println("\nUsername available! , Please re-enter");
        } while (index != -1);
        String password = getPassword();
        User user = new User(username, password);
        user.setRole1(new Role("USER"));
        users.add(user);
        System.out.println("Successfully register!");
        ioTextFile.writeFile(users, "src/File/UserAccount.txt");
    }
//    public void registerAccount() {
//        Scanner scanner = new Scanner(System.in);
//        try {
//
//            System.out.println("Enter new Account:");
//            String account = scanner.nextLine();
//            Pattern pattern = Pattern.compile("^[0-9A-Za-z]{8,16}$");
////            boolean flag = false;
//            for (User user : users){
//                if (user.getUserName().equals(account)){
//                    System.err.println("Account already exists!");
////                    flag = true;
//                }
//            }
////            if (!flag){
////                return;
////            }
//            if (pattern.matcher(account).find()) {
//                System.out.println("Ok!");
//            } else {
//                System.out.println("Invalid account, please input again");
//            }
//
//            System.out.println("Enter new passWord: ");
//            String password = scanner.nextLine();
//            Pattern pattern1 = Pattern.compile("^[0-9A-Za-z]{8,16}$");
//            if (pattern1.matcher(account).find()) {
//                System.out.println("OK!");
//            } else {
//                System.out.println("Invalid password, please input again");
//            }
//
//            User user = new User(account, password);
//            user.setRole1(new Role("USER"));
//            users.add(user);
//            user.setUserName(user.getUserName());
//
//            System.out.println("Successfully register!");
//            ioTextFile.writeFile(users, "src/File/UserAccount.txt");
//
//
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//    }
    public void loginAccount() {
        Scanner scanner = new Scanner(System.in);
        users = ioTextFile.readFile("src/File/UserAccount.txt");
        try {
            System.out.println("Enter username: ");
            String username = scanner.nextLine();
            System.out.println("Enter password");
            String password = scanner.nextLine();

            for (User user : users) {
                if (user.getUserName().equals(username) && user.getPassWord().equals(password)) {
                    if (user.getRole1().getRole_name().equals("ADMIN")) {
                        System.out.println("Success login!");
                        shirtSystem.menuAdmin();
                        break;

                    } else if (user.getRole1().getRole_name().equals("USER")) {
                        System.out.println("Success login User !");
                        shirtSystem.menuUser();
                        break;
                    }
                    break;
                } 
            }
        } catch (InputMismatchException e) {
            System.err.println("Wrong account ! ");

        }
    }
////    public void showUser(){
////        for (User user : users){
////            if (users.isEmpty()){
////                System.err.println("No account!");
////            } else {
////                System.out.printf("%-10s%-20s%-15s%-20s%s" +"username" + user.getUserName() + user.getPassWord()+ "password\n");
////
////            }
////        }
//
//
//    }



}





