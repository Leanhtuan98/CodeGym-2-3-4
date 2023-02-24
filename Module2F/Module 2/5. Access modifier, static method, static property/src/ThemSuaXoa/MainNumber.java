package ThemSuaXoa;

import java.util.Scanner;

public class MainNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Quan ly mang so");
            System.out.println("1.Hien thi so");
            System.out.println("2.Them so");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    ManagerNumber.show();
                    break;
                case 2:
                    System.out.println("Nhap so can them");
                    int num = scanner.nextInt();
                    ManagerNumber.add(num);
                default:
                    System.exit(0);
            }
        }
    }
}
