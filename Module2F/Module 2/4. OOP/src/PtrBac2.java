import java.util.Scanner;

public class PtrBac2 {
    double a, b, c;

    public PtrBac2() {
    }

    public PtrBac2(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double tinhDelTa() {
        double DenlTa = this.b * this.b - 4 * this.a * this.c;
        return DenlTa;
    }

    public double nghiem1() {
        double Nghiem1 = (-this.b + Math.pow(tinhDelTa(), 0.5)) / (2 * this.a);
        return Nghiem1;
    }

    public double nghiem2() {
        double Nghiem2 = (-this.b - Math.pow(tinhDelTa(), 0.5)) / (2 * this.a);
        return Nghiem2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao thong tin: ");
        System.out.println("Nhap a : ");
        double a = scanner.nextDouble();
        System.out.println("Nhap b: ");
        double b = scanner.nextDouble();
        System.out.println("Nhap c: ");
        double c = scanner.nextDouble();
        System.out.println("Phuong trinh co dang : " + a + "x2 " + "+" + b + "x " + "+" + c + " = 0");
        PtrBac2 phuongtrinhbac2 = new PtrBac2(a, b, c);
        System.out.println("DelTa cua phuong trinh la :" + phuongtrinhbac2.tinhDelTa());
        if (phuongtrinhbac2.tinhDelTa() >= 0) {
            System.out.println("Phuong trinh co 2 nghiem phan biet: ");
            System.out.println("Nghiem 1 la :" + phuongtrinhbac2.nghiem1());
            System.out.println("Nghiem 2 la :" + phuongtrinhbac2.nghiem2());
        } else System.out.println("Phuong Trinh vo nghiem ");
    }
}

