import java.util.Scanner;

public class Money {
    public static void main(String[] args) {
        double money = 1.0;
        int month = 1;
        double interestRate = 1.0;
        Scanner input = new Scanner(System.in);
        //Nhap so tien gui
        System.out.println("Enter investment amount: ");
        money = input.nextInt();
        //Nhap so thang gui
        System.out.println("Enter number of months: ");
        month = input.nextInt();
        //Nhap lai suat
        System.out.println("Enter annual interest rate in percentage: ");
        interestRate = input.nextDouble();
        //Tinh lai suat nhan duoc
        double totalInterest = 0;
        for (int i = 0; i < month; i++) {
            totalInterest += money * (interestRate/100)/12 * month;
            System.out.println("Total of interest: " + totalInterest);

        }
    }
}
