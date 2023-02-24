package QuanLyNhanVien;

import java.util.Scanner;

public class ControllerNhanVien {
    static NhanVien[] listNV = new NhanVien[1];
    static Scanner scanner = new Scanner(System.in);

    public  NhanVien createNhanVien(boolean isKySu){
        System.out.println("Nhap id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap name");
        String name = scanner.nextLine();
        System.out.println("Nhap tuoi");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap dia chi");
        String address = scanner.nextLine();
        System.out.println("Nhap ngay lam viec");
        double workingDay = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhap luong");
        double salary = Double.parseDouble(scanner.nextLine());

        if (!isKySu) {
            CongNhan congNhan = new CongNhan(id,name,age,address,workingDay,salary);
            return congNhan;
        } else {
            System.out.println("Nhap payRateSalary");
            double payRateSalary = Double.parseDouble(scanner.nextLine());
            KySu kySu = new KySu(id,name,age,address,workingDay,salary,payRateSalary);
            return kySu;
        }
    }
    public static NhanVien[] addNhanVien(NhanVien nhanVien) {
        NhanVien[] newArrNV = new NhanVien[listNV.length + 1];
        for (int i = 0; i < listNV.length; i++) {
            newArrNV[i] = listNV[i];
        }
        newArrNV[listNV.length] = nhanVien;
        return newArrNV;
    }
}
