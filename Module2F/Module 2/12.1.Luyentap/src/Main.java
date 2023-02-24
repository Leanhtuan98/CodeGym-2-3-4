import KhoiTaoDoiTuong.NhanVien;
import QuanLiDoiTuong.ManagerNhanVien;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ManagerNhanVien managerNhanVien = new ManagerNhanVien();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Quan li nhan vien");
            System.out.println("1. Them nhan vien");
            System.out.println("2. Xoa Nhan vien");
            System.out.println("3. Sua nhan vien");
            System.out.println("4. Tim Kiem Nhan vien");
            System.out.println("5. Tim 3 nhan vien luong cao nhat");
            System.out.println("6. Tim Nhan vien sinh nhat trong thang nay");
            System.out.println("7. Sap xep ten nhan vien");
            System.out.println("8.Hien thi");
            System.out.println("9. Thoat");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    managerNhanVien.AddNhanVien();
                    break;
                case 2:
                    managerNhanVien.DeleteNhanVien();
                    break;
                case 3:
                    managerNhanVien.Edit();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    managerNhanVien.show();
                    break;
                default:
                    return;

            }

        }
    }

}
