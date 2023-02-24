package Main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quan li nhan vien");
        System.out.println("1.Them nhan vien");
        System.out.println("2.Sua nhan vien");
        System.out.println("3.Xoa nhan vien");
        System.out.println("4.Tim kiem nhan vien");
        System.out.println("5.Hien nhan vien");
        System.out.println("6.Hien thi luong nhan vien");
        System.out.println("7.Exit");

        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            System.out.println("Them nhan vien");
            System.out.println("1.Them FullTime");
            System.out.println("2.Them PartTime");
            int choice2 = Integer.parseInt(scanner.nextLine());
            if (choice2 == 1) {
                System.out.println("1.Nhan vien FullTime");
            } if (choice2 == 2) {
                System.out.println("2. Nhan vien PartTime");
            }
        }
    }

}
