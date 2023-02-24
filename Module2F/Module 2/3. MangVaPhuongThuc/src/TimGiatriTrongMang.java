import java.util.Scanner;

public class TimGiatriTrongMang {
    public static void main(String[] args) {
        //Khai báo mảng chứa danh sách sinh viên
        String[] students = {"A","B","C","D"};
        //Khai báo biến lưu tên tìm kiếm và gán giá trị nhập vào
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name's student: ");
        String input_name = scanner.nextLine();
        boolean isExist = false;
        for (String student : students) {
            if (student.equals(input_name)) {
                System.out.println("Position of the studens in the list");
                isExist = true;
                break;
            }

        }
        if (!isExist){
            System.out.println("Not found " + input_name + " in the list");
        }
    }
}
