import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManager {
    public ArrayList<Student> students;

    public Scanner scanner = new Scanner(System.in);

    public void addStudent() {
        try {
            System.out.println("Nhập mã số sinh viên: ");
            String code = scanner.nextLine();
            System.out.println("Nhập tên sinh viên: ");
            String name = scanner.nextLine();
            System.out.println("Nhập tuổi sinh viên: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập giới tính sinh viên: ");
            String gender = scanner.nextLine();
            System.out.println("Nhập địa chỉ sinh viên: ");
            String address = scanner.nextLine();
            System.out.println("Nhập điểm trung bình: ");
            Double markAvg = Double.parseDouble(scanner.nextLine());
            students.add(new Student(code, name, age, gender, address, markAvg));
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }

    public Student checkExist(String code) {
        for (Student student : students) {
            if (student.getCode().equals(code)) {
                return student;
            }
        }
        return null;
    }

    public void deleteStudent() {
        try {
            System.out.println("Nhập mã số sinh viên muốn xóa: ");
            String code = scanner.nextLine();
            Student codeDelete;
            if ((codeDelete = checkExist(code)) != null) {
                System.out.println("Nhập Y(YES) hoặc N(NO) để xóa");
                String confirm = scanner.nextLine();
                if (confirm.equals("Y")) {
                    students.remove(codeDelete);
                }

            } else {
                System.out.println("Không có mã sinh viên! ");
            }
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println(e.getMessage());
        }

    }

    public void updateStudent() {
        System.out.println("Nhập mã sinh viên muốn sửa: ");
        String code = scanner.nextLine();


    }
}
