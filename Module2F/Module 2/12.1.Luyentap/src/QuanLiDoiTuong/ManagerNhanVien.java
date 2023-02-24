package QuanLiDoiTuong;

import KhoiTaoDoiTuong.NhanVien;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerNhanVien {

    static ArrayList<NhanVien> nhanViens = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public  NhanVien AddNhanVien() {


        System.out.println("Nhap ten nhan vien: ");
        String name = scanner.nextLine();

        System.out.println("Nhap tuoi nhan vien: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhap luong co ban: ");
        double salary = Double.parseDouble(scanner.nextLine());

        System.out.println("Nhap sinh nhat nhan vien: ");
        String birthDay = scanner.nextLine();

        System.out.println("Nhap gioi tinh nhan vien : ");
        String gender = scanner.nextLine();

        NhanVien nhanVien = new NhanVien(name, age, salary, birthDay, gender);

        nhanViens.add(nhanVien);
        return nhanVien;
    }

    public void   DeleteNhanVien() {
        System.out.println("Nhap id muon xoa");
        int id = Integer.parseInt(scanner.nextLine());
        nhanViens.remove(id);
        System.out.println("Xoa thanh cong");
    }

    public void Edit() {
        System.out.println("Sua theo id nhan vien");
        int id = Integer.parseInt(scanner.nextLine());
        while (true) {
            System.out.println("1. Sua ten nhan vien");
            System.out.println("2. Sua tuoi nhan vien");
            System.out.println("3. Sua luong nhan vien");
            System.out.println("4. Sua sinh nhat nhan vien");
            System.out.println("5. Sua gioi tinh nhan vien");
            System.out.println("6.Quay lai");

            int choice1 = Integer.parseInt(scanner.nextLine());

            switch (choice1) {
                case 1:
                    System.out.println("nhap ten moi: ");
                    String name = scanner.nextLine();
                    nhanViens.get(id).setName(name);
                    System.out.println("Ten da duoc sua");
                    break;
                case 2:
                    System.out.println("Nhap tuoi moi: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    nhanViens.get(id).setAge(age);
                    System.out.println("Tuoi moi da duoc sua");
                    break;
                case 3:
                    System.out.println("Nhap luong moi: ");
                    double salary = Double.parseDouble(scanner.nextLine());
                    nhanViens.get(id).setSalary(salary);
                    System.out.println("Luong moi da duoc sua");
                    break;
                case 4:
                    System.out.println("Nhap ngay sinh moi: ");
                    String birthDay = scanner.nextLine();
                    nhanViens.get(id).setBirthDay(birthDay);
                    System.out.println("Sinh nhat da duoc sua");
                    break;
                case 5:
                    System.out.println("Nhap gioi tinh moi: ");
                    String gender = scanner.nextLine();
                    nhanViens.get(id).setGender(gender);
                    break;
                case 6:
                    return;
            }
        }

    }

    public void show() {
        for (int i = 0; i < nhanViens.size(); i++) {
            System.out.println(nhanViens.get(i).toString());

        }
    }
}
