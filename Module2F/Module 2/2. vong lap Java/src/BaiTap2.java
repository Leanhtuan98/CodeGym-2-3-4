import java.util.Scanner;

public class BaiTap2 {
    public static void main(String[] args) {
        int number;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter n: ");
            number = scanner.nextInt();
            ktraSNT(number);
        } while (number != 0);

    }

    public static void ktraSNT(int number) {
        int count = 0;
        for(int i=1; i <= number; i++){
            if(number % i == 0){
                count++;
            }
        }
        if (count == 2) {
            System.out.printf("%d is a price\n", number);
        } else {
            System.out.printf("%d is not a price\n", number);
        }
    }
}