package OfficialProgram;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerProduct managerProduct =new ManagerProduct();
        while (true) {
            System.out.println("Quản lý sản phẩm");
            System.out.println("1.Thêm sản phẩm");
            System.out.println("2.Sửa");
            System.out.println("3.Xóa");
            System.out.println("4.Hiển thị");
            System.out.println("5.Thoát");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    Product product = managerProduct.creatProduct();
                    managerProduct.add(product);
                    break;
                case 2:
                    System.out.println("Nhập vị trí muốn sửa");
                    int indexExit = Integer.parseInt(scanner.nextLine());
                    Product productEdit = managerProduct.creatProduct();
                    managerProduct.edit(indexExit,productEdit);
                    break;
                case 3:
                    System.out.println("Nhập vị trí muốn xóa");
                    int indexDelete = Integer.parseInt(scanner.nextLine());
                    managerProduct.delete(indexDelete);
                    break;
                case 4:
                    managerProduct.show();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}
