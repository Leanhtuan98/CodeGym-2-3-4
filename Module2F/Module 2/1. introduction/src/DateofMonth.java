import java.util.Scanner;

public class DateofMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Nhập thông tin về tháng, trương trình cần biết người dùng muốn tìm số ngày mấy của tháng.
        System.out.println("Which month that you want to count dáy?");
        int month = scanner.nextInt();

        switch (month) {
            case 2:
                System.out.println("The month '2' has 28 or 29 day!");
                break;
        }
    }
}
