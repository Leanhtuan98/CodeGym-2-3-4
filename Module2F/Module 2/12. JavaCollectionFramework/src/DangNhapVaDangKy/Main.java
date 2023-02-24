package DangNhapVaDangKy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ManagerAccount managerAccount = new ManagerAccount();
        while (true) {
            System.out.println("Menu dang nhap");
            System.out.println("1.Dang Ky");
            System.out.println("2.Dang Nhap");
            System.out.println("3.Doi Mat Khau");
            System.out.println("4.Thoat");

            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                managerAccount.DangKy();
            }
            else if (choice == 2) {
                managerAccount.DangNhap();
            }
            else if (choice == 3) {
                managerAccount.ChangePassword();
            }
            else {
                break;
            }
        }
    }
}
