package DangNhapVaDangKy;

import java.util.HashMap;
import java.util.Scanner;

public class ManagerAccount {
    HashMap<String, Integer> Account = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public void DangKy() {
        System.out.println("Enter Name");
        String name = scanner.nextLine();

        System.out.println("Enter PassWord");
        Integer password = Integer.parseInt(scanner.nextLine());

        Account.put(name, password);
        System.out.println("Dang ky thanh cong");
    }

    public void DangNhap() {
        System.out.println("Enter Name");
        String username = scanner.nextLine();
        System.out.println("Enter password");
        int password = Integer.parseInt(scanner.nextLine());

        if (CheckName(username)&& Account.get(username).equals(password)){
            System.out.println("Dang nhap thanh cong");
        }
        else {
            System.out.println("Dang nhap that bai");
        }
    }

    public  boolean CheckName(String username) {
        if (Account.containsKey(username)) {
            return true;
        }
        return false;


    }

    public void ChangePassword() {
        System.out.println("Enter name");
        String username = scanner.nextLine();
        System.out.println("Enter OldPassWord");
        Integer password = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter NewPassWord");
        Integer newPassWord = Integer.parseInt(scanner.nextLine()) ;
        if (Account.containsKey(username)){
            if (Account.get(username).equals(password) && CheckName(username)) {
                Account.put(username,newPassWord);
                System.out.println("Doi mat khau thanh cong");
            }
            else {
                System.out.println("Doi that bai");
            }
        } else {
            System.out.println("Tai khoan khong ton tai, moi nhap lai");
        }
    }
}

