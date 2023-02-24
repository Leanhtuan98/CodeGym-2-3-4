import java.util.Scanner;

public class ControllerNhanVien {
    //Quản lý nhân viên trên một mảng nên sẽ tạo ra một mảng để quản lí nhân viên

    static NhanVien[] listnv = new NhanVien[1];
    static Scanner scanner = new Scanner(System.in);

    public static NhanVien createNhanVien(boolean isKySu) {
        System.out.println("Nhap id");
        // Ép kiểu từ số thành chuỗi
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhap name");
        String name = scanner.nextLine();
        System.out.println("Nhap address");
        String address = scanner.nextLine();
        System.out.println("Nhap age");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap workingDay");
        double workingDay = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap salary");
        double salary = Double.parseDouble(scanner.nextLine());

        if (!isKySu) {
            CongNhan congNhan = new CongNhan(id, name, age, address, workingDay, salary);
            return congNhan;
        } else {
            System.out.println("Nhap payRateSalary");
            double payRateSalary = Double.parseDouble(scanner.nextLine());
            KySu kySu = new KySu(id, name, age, address, workingDay, salary, payRateSalary);
            return kySu;
        }
    }

    // Them Nhan vien
    public static NhanVien[] addNhanVien(NhanVien nhanVien) {
        NhanVien[] newArrNV = new NhanVien[listnv.length + 1];

        for (int i = 0; i < listnv.length; i++) {
            newArrNV[i] = listnv[i];
        }
        newArrNV[listnv.length] = nhanVien;
        return newArrNV;
    }
}
