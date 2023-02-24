import KhoiTaoDoiTuong.NhanVien;
import Manager.Manager_NhanVien;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Manager_NhanVien manager_nhanVien = new Manager_NhanVien();
        System.out.println("Quan li nhan vien");
        System.out.println("1.Them nhan vien");
        System.out.println("2.Sua nhan vien");
        System.out.println("3.Xoa nhan vien");
        System.out.println("4.Tim nhan vien");
        System.out.println("5.Hien thi luong");
        System.out.println("6.Hien thi nhan vien");
        System.out.println("7.Exit");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                manager_nhanVien.show();
                break;
            case 2:
                System.out.println("1.Cong Nhan");
                System.out.println("2.Ky Su");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                }

        }
    }
}
