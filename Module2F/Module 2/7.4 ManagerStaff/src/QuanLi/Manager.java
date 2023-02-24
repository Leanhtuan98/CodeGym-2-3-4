package QuanLi;

import KhoiTaoDoiTuong.FullTime;
import KhoiTaoDoiTuong.NhanVien;
import KhoiTaoDoiTuong.PartTime;

import java.util.Scanner;

public class Manager {
// Quản lí nhân viên qua mảng , tạo ra một mảng rỗng để chưa các phần tử nhập vào
    NhanVien[] nhanViens = new NhanVien[0];
    Scanner scanner = new Scanner(System.in);

// Tạo hàm để show kết quả ra màn hình
    public void show(){
        for (int i = 0; i < nhanViens.length; i++) {
            System.out.println(nhanViens[i].toString());
        }
    }
// Tạo mảng mới có chiều dài lớn hơn mảng cũ

    public void add(NhanVien nhanVien) {
        NhanVien[] newArr = new NhanVien[nhanViens.length + 1];
        for (int i = 0; i < nhanViens.length ; i++) {
            newArr[i] = nhanViens[i];
        }
        newArr [newArr.length-1] = nhanVien;
        nhanViens = newArr;
    }
// Tạo một hàm để tạo ra để nhập thông tin

    public NhanVien taoNhanVien(boolean isFullTime) {
        System.out.println("Nhap ten nhan vien");
        String name = scanner.nextLine();
        System.out.println("Nhap tuoi nhan vien");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap gioi tinh nhan vien");
        String gender = scanner.nextLine();

        // Kiểm tra xem giá trị nhập vào là Fulltime hay Parttime

        if (isFullTime) {
            System.out.println("Nhap he so nhan vien: ");
            double heSo = Double.parseDouble(scanner.nextLine());
            return new FullTime(name,age,gender,heSo);
        }else {
            System.out.println("Nhap so ngay lam: ");
            int soNgayLam = Integer.parseInt(scanner.nextLine());
            return new PartTime(name,age,gender,soNgayLam);
        }
    }
// Tìm kiếm nhân viên theo vị trí index:

    public int findIndexByName(String name){
        for (int i = 0; i < nhanViens.length; i++) {
            if (name.equals(nhanViens[i].getName())){
                return i;
            }
        }
        return -1;
    }
// Sửa

    public void edit(String name) {
        int index = findIndexByName(name);
        if (index != 1) {
            System.out.println("Ban muon sua thanh nhan vien gi");
            System.out.println("1.Nhan vien Full time ");
            System.out.println("2.Nhan vien Part time ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                NhanVien fulltime = taoNhanVien(true);
                nhanViens[index] = fulltime;
            }
            if (choice == 2) {
                NhanVien parttime = taoNhanVien(false);
                nhanViens[index] = parttime;
            }
        }
    }
// Xoa

    public void delete(String name) {
        int index = findIndexByName(name);
        if (index != -1){
            NhanVien[] newArr = new NhanVien[nhanViens.length-1];
            for (int i = 0; i < newArr.length; i++) {
                if (i < index) {
                    newArr[i] = nhanViens[i];
                }
                else {
                    newArr[i] = nhanViens[i+21];
                }
            }
            nhanViens = newArr;
        }
    }
// Tinh Luong

    public void salary() {
        for (int i = 0; i < nhanViens.length; i++) {
            System.out.println(nhanViens[i] .getName() + "Co Luong la" + nhanViens[i].salary());
            
        }
    }
}
