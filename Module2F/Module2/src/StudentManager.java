import IO.IOTextFile;

import java.util.*;

public class StudentManager {

    public ArrayList<Student> students;

    public Scanner scanner = new Scanner(System.in);

    public IOTextFile<Student> ioTextFile = new IOTextFile();

    public StudentManager() {
        students = ioTextFile.readFile("src/ListStudent.txt");
    }

    public void addStudent() {
        try {
            System.out.println("Enter code student: ");
            String code = scanner.nextLine();
            System.out.println("Enter name student: ");
            String name = scanner.nextLine();
            System.out.println("Enter age student: ");
            Integer age = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter gender student: ");
            String gender = scanner.nextLine();
            System.out.println("Enter address student: ");
            String address = scanner.nextLine();
            System.out.println("Enter markAvg student: ");
            Double markAvg = Double.parseDouble(scanner.nextLine());
            students.add(new Student(code, name, age, gender, address, markAvg));
            ioTextFile.writeFile(students, "src/ListStudent.txt");
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteStudent() {
        try {
            System.out.println("Enter code student want to delete: ");
            String code = scanner.nextLine();
            Student codeDelete;
            if ((codeDelete = checkExist(code)) != null) {
                System.out.println("Enter Y(YES)/N(NO) to delete: ");
                String confirm = scanner.nextLine();
                if (confirm.equals("Y")) {
                    students.remove(codeDelete);
                    ioTextFile.writeFile(students, "src/ListStudent.txt");
                }
            } else {
                System.err.println("Invalid code!");
            }
        } catch (NumberFormatException | InputMismatchException e) {
            System.err.println(e.getMessage());
        }
    }

    public void updateStudent(ArrayList<Student> students) {
        try {
            System.out.println("Enter code student want to update: ");
            String code = scanner.nextLine();
            Student codeUpdate;
            if ((codeUpdate = checkExist(code)) != null) {
                System.out.println("Enter new code: ");
                code = scanner.nextLine();
                if (!code.equals("")) {
                    codeUpdate.setCode(code);
                }
                System.out.println("Enter new name: ");
                String name = scanner.nextLine();
                if (!name.equals("")) {
                    codeUpdate.setName(name);
                }
                System.out.println("Enter new age: ");
                String age = scanner.nextLine();
                if (!age.equals("")) {
                    codeUpdate.setAge(Integer.parseInt(age));
                }
                System.out.println("Enter new gender: ");
                String gender = scanner.nextLine();
                if (!gender.equals("")) {
                    codeUpdate.setGender(gender);
                }
                System.out.println("Enter new address: ");
                String address = scanner.nextLine();
                if (!address.equals("")) {
                    codeUpdate.setAddress(address);
                }
                System.out.println("Enter new markAvg: ");
                String markAvg = scanner.nextLine();
                if (!markAvg.equals("")) {
                    codeUpdate.setMarkAvg(Double.parseDouble(markAvg));
                }
                ioTextFile.writeFile(students, "src/ListStudent.txt");
            } else {
                System.err.println("Invalid code!");
            }
        } catch (NumberFormatException | InputMismatchException e) {
            System.err.println(e.getMessage());
        }
    }

    public Student checkExist(String code) {
        for (Student s : students) {
            if (s.getCode().equals(code)) {
                return s;
            }
        }
        return null;
    }

    public void sortByMarkAvgIncrease() {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int) (o1.getMarkAvg() - o2.getMarkAvg());
            }
        });
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public void sortByMarkAvgDecrease() {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int) (o2.getMarkAvg() - o1.getMarkAvg());
            }
        });
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public void display() {
        ioTextFile.readFile("src/ListStudent.txt");
        System.err.printf("%-10s%-20s%-15s%-20s%s%20s", "CODE", "NAME", "AGE", "ADDRESS", "GENDER", "MARK_AVG\n");
        for (Student s : students)
            s.display();
    }



}
