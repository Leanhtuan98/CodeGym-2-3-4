package BaiTap;

import java.util.Scanner;

public class DemSolanXuatHien {
    public static void countSame(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            int count = 1;
            for (int j = i + 1; j < b.length; j++) {
                if (a[i] == a[j]) {
                    count++;
                    b[j] = 0;
                }

            }
            if (b[i] != 0) {
                b[i] = count;
            }
        }
        System.out.println("ket qua la: ");
        for (int i = 0; i < b.length; i++) {
            if (b[i] != 0) {
                System.out.println("so" + a[i] + "xuat hien" + b[i] + "so lan");

            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[10];
        int[] b = new int[10];

        System.out.println("Nhap cac phan tu");
        for (int i = 0; i < b.length; i++) {
            a[i] = scanner.nextInt();
            b[i] = -1;
        }
    }
}
