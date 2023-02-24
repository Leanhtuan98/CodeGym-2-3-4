import KhoiTaoDoiTuong.NhanVien;
import QuanLi.Manager;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Manager manager = new Manager();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Quan ly nhan vien");
            System.out.println("1.Them nhan vien");
            System.out.println("2.Sua nhan vien");
            System.out.println("3.Xoa nhan vien");
            System.out.println("4. Hien thi  nhan vien");
            System.out.println("5. Hien thi luong nhan vien");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    menuCreateStaff();
                    break;
                case 2:
                    System.out.println("nhap ten muon sua");
                    String nameEdit = scanner.nextLine();
                    manager.edit(nameEdit);
                    break;
                case 3:

                    System.out.println("nhap ten muon xoa");
                    String nameDelete = scanner.nextLine();

                    manager.delete(nameDelete);
                    break;
                case 4:
                    manager.show();
                    break;
                case 5:
                    manager.salary();
                    break;
                default:
                    return;
            }
        }
    }

    public static void menuCreateStaff() {
        System.out.println("1.Nhan vien full time");
        System.out.println("2.Nhan vien part time");
        int choice2 = Integer.parseInt(scanner.nextLine());
        if (choice2 == 1) {
            NhanVien fulltime = manager.taoNhanVien(true);
            manager.add(fulltime);
        }
        if (choice2 == 2) {
            NhanVien parttime = manager.taoNhanVien(false);
            manager.add(parttime);
        }
    }
}