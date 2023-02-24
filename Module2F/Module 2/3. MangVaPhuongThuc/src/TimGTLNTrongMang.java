import java.util.Scanner;

public class TimGTLNTrongMang {
    public static void main(String[] args) {
        int[] number;
        int size;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Nhập vào đây");
            size = scanner.nextInt();
            if (size > 10 || size < 1){
                System.out.println("Không nhập lớn hơn 10");
            }
        } while (size > 10 || size <1);
        number = new int[size];
        int i = 0;
        while (i < number.length) {
            System.out.println("Nhập vào phần tử " + ( i+ 1) + " :");
            number[i] = scanner.nextInt();
            i++;
            System.out.println("Danh sách: ");
        }

    }
}
