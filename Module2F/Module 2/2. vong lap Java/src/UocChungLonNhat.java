import java.util.Scanner;

public class UocChungLonNhat {
    //Khai bao hai so nguyen a,b va nhap gia tri cho a,b tu ban phim
    public static void main(String[] args) {
        int a;
        int b;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a: ");
        a = input.nextInt();
        System.out.println("Enter b: ");
        b = input.nextInt();
        // su dung ham abs() de tra ve gia tri tuyet doi (phan duong) cua a,b
        a = Math.abs(a);
        b = Math.abs(b);
        // Kiem tra a , b co bang 0 hay khong
        if(a == 0 || b == 0) {
            System.out.println("No greatest common factor");
        }
        while (a != b) {
            if (a > b){
                a = a - b;
            } else {
                b = b - a;
            }
        }
        System.out.println("Greatest common factor: " + a);
    }
}
