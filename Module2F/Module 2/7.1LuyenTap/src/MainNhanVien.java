import java.util.Scanner;

public class MainNhanVien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quan ly nhan vien");
        System.out.println("1.Them nhan vien");
        System.out.println("2.Tim kiem nhan vien");
        System.out.println("3.Xoa nhan vien");
        System.out.println("4.Sua nhan vien");
        System.out.println("5.Hien thi nhan vien");
        System.out.println("6.Sap xep vien");
        System.out.println("7.Exit");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                System.out.println("1.Cong nhan");
                System.out.println("2.Ky Su");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        // thêm nhân viên
                        break;
                    case 2:
                        // thêm kỹ sư
                        break;
                }
        }
    }
}
