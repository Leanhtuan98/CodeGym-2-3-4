package Manager;

import KhoiTaoDoiTuong.CongNhan;
import KhoiTaoDoiTuong.KySu;
import KhoiTaoDoiTuong.NhanVien;

import java.util.Scanner;

public class Manager_NhanVien {
    static NhanVien[] listNv = new NhanVien[0];
    static Scanner scanner = new Scanner (System.in);

    public void show(){
        for (int i = 0; i < listNv.length; i++) {
            System.out.println(listNv[i].toString());
        }
    }

    public NhanVien createNhanVien(boolean isKySu) {
        System.out.println("Quan li nhan vien");
        System.out.println("Nhap id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("1.Nhap ten");
        String name = scanner.nextLine();
        System.out.println("2.Nhap tuoi");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("3.Nhap gioi tinh");
        String gender = scanner.nextLine();

        if (isKySu ) {
            System.out.println("Nhap he so");
            double heSo = Double.parseDouble(scanner.nextLine());
            KySu kySu = new KySu( id, name, age, gender,heSo);
            return kySu;
        }
        else {
            System.out.println("Nhap so buoi");
            double soBuoi = Double.parseDouble(scanner.nextLine());
            CongNhan congNhan = new CongNhan(id,name,age,gender,soBuoi);
            return congNhan;

        }
    }

    public static void add(NhanVien nhanVien) {
        NhanVien [] newArr = new NhanVien[listNv.length+1];
        for (int i = 0; i < listNv.length; i++) {
            newArr[i] = listNv[i];
        }
        newArr[listNv.length -1] = nhanVien ;
        listNv = newArr;
    }
}
