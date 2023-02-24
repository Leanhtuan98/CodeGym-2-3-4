// Nhập vào số n từ bàn phím, in ra các số chia hết cho 3 trong khoảng từ 1 đến n,

import java.util.Scanner;

public class BaiTap1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Enter a nuber : ");
        int number = scanner.nextInt();
        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            }


        }
    }
}
