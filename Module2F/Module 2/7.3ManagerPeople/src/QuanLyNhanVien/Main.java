package QuanLyNhanVien;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ControllerNhanVien nhanVien1 = new ControllerNhanVien();

        System.out.println("Quan li nhan vien");
        System.out.println("1.Them nhan vien");
        System.out.println("2.Tim kiem nhan vien");
        System.out.println("3.Xoa nhan vien");
        System.out.println("4.Sua nhan vien");
        System.out.println("5.Hien thi  nhan vien");
        System.out.println("6. Sap xep nhan vien");
        System.out.println("7. Exit");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1 :
                System.out.println("1.Cong Nhan");
                System.out.println("2. Ky Su");

                switch (choice){
                    case 1:


                        break;
                    case 2:
                        //them ky su;
                        break;
                }
        }

    }
}
