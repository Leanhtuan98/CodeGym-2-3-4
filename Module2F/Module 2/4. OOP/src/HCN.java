import java.util.Scanner;

public class HCN {
    double chieudai, chieurong;
//    public HCN() {
//    }

    public HCN(double chieudai, double chieurong) {
        this.chieudai = chieudai;
        this.chieurong = chieurong;
    }
    public double getdienTich() {
        return this.chieudai * this.chieurong;
    }
    public double getchuVi() {
        return (this.chieudai + this.chieurong) * 2;
    }
    public String hienThi() {
        return "HCN{" + "chieudai = " +chieudai + ", chieurong="+chieurong + "}";

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap chieu dai: ");
        double chieudai = scanner.nextDouble();
        System.out.println("nhap chieu rong");
        double chieurong = scanner.nextDouble();
        HCN hcn = new HCN(chieudai,chieurong);
        System.out.println("HCN co \n" + hcn.hienThi());
        System.out.println("CHU Vi HCN "+ hcn.getchuVi());
        System.out.println("Dien Tich HCN "+hcn.getdienTich());
    }
}

