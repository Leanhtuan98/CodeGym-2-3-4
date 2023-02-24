public class abcTest {
    public static class Student8 {
        int rollno;
        String name;
        String college = "abc";

        Student8(int r, String n) {
            rollno = r;
            name = n;
        }

        void display() {
            System.out.println(rollno + " - " + name + " - " + college);
        }

        public static void main(String args[]) {
            Student8 s1 = new Student8(111, "Haha");
            Student8 s2 = new Student8(222, "Minh");
            Student8 s3 = new Student8(333 , "HAHA");

            s1.display();
            s2.display();
            s3.display();
        }
    }
}
