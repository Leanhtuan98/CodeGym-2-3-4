import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public  static  ArrayList<Student> students;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();
        do {
            System.out.println("-----PROGRAMING MANAGEMENT STUDENT-----");
            System.out.println("Enter your choice follow number: ");
            System.out.println("1. View list students");
            System.out.println("2. Add new");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Sort");
            System.out.println("6. Read from file");
            System.out.println("7. Write to file");
            System.out.println("0. Exit");
            System.out.println("Select function: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice < 0 || choice > 6) {
                    throw new RuntimeException();
                }
                switch (choice) {
                    case 1:
                        studentManager.display();
                        break;
                    case 2:
                        studentManager.addStudent();
                        break;
                    case 3:
                        studentManager.updateStudent(students);
                        break;
                    case 4:
                        studentManager.deleteStudent();
                        break;
                    case 5:
                        menuSort(studentManager);
                        break;
                    case 0:
                        System.exit(0);
                }
            } catch (Exception e) {
                System.err.println("Please re-enter your selection!");
            }
        } while (true);
    }

    public  static  void menuSort(StudentManager studentManager) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("-----SELECT SORT-----");
            System.out.println("Enter your choice follow number: ");
            System.out.println("1. Sort MarkAvg Increase");
            System.out.println("2. Sort MarkAvg Decrease");
            System.out.println("3. Back");
            System.out.println("Select function: ");
            try {
                int choice1 = Integer.parseInt(scanner.nextLine());
                if (choice1 < 0 || choice1 > 8) {
                    throw new RuntimeException();
                } if (choice1 == 3) {
                    break;
                }
                switch (choice1) {
                    case 1:
                        studentManager.sortByMarkAvgIncrease();
                        break;
                    case 2:
                        studentManager.sortByMarkAvgDecrease();
                        break;
                }
            } catch (Exception e) {
                System.err.println("Please re-enter your selection!");
            }
        } while (true);
    }
}