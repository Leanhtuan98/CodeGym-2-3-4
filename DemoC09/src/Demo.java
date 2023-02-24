import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {

        //Khai bao bien;


//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("What is your name? : ");
//        String name = scanner.nextLine();
//        System.out.println("How old are you?");
//        int age = scanner.nextInt();
//        scanner.nextLine();
//        System.out.println("What is your favorite food?");
//        String food = scanner.nextLine();
//
//        System.out.println("Hello " + name);
//        System.out.println("You are " + age + "  years old" );
//        System.out.println("You like " + food);
//        int friends = 10;
//        friends = friends % 3;


        // Hien bang ra man hinh de nhap nhap thong tin.


//        String name = JOptionPane.showInputDialog("Enter your name");
//        JOptionPane.showMessageDialog(null, "Hello" + name);
//
//        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age"));
//        JOptionPane.showMessageDialog(null,"You are "+ age + " years old");
//
//        double height = Double.parseDouble(JOptionPane.showInputDialog("Enter your height"));
//        JOptionPane.showMessageDialog(null,"You are "+ height + " cm");


        // Tim max,min,abs ( gia tri tuyet doi), sqrt ( can bac 2), round hoac floor (lam tron xuong), celi (lam tron len)


//        double x = 3.14;
//        double y = -10;
//        double z = Math.floor(x);
//        System.out.println(z);


        // Vi du : Tim canh huyen cua tam giac ABC.


//        double x;
//        double y;
//        double z;
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Nhap x: ");
//        x = scanner.nextDouble();
//        System.out.println("Nhap y: ");
//        y = scanner.nextDouble();
//
//        z = Math.sqrt((x*x) + (y*y));
//        System.out.println("Canh huyen cu tam giac ABC la : " + z);
//        scanner.close();


        // Radom of int, double, boolean,

//        Random random = new Random();

//        int x = random.nextInt(6) + 1;
//        double y = random.nextDouble();
//        boolean z = random.nextBoolean();
//
        // if() , else
//        int age = 10;
//        if (age >= 18) {
//            System.out.println("You are adult!");
//        }
//        else {
//            System.out.println("You are not an adult!");
//        }


        // switch case.

//        String day = "Thu 6";
//        switch(day) {
//            case "Monday":
//                System.out.println("It is Monday");
//                break;
//            case "Tuesday":
//                System.out.println("It is Tuesday");
//                break;
//            case "Thu 4":
//                System.out.println("It is thu tu");
//                break;
//            case "Thu 5":
//                System.out.println("It is thu 5");
//                break;
//            case "Thu 6":
//                System.out.println("It is Thu 6");
//                break;
//            case "Thu 7":
//                System.out.println("It is Thu 7");
//                break;
//        }

         // Toan tu &&, ||, !

//        int temp = 25;
//
//        if (temp> 30) {
//            System.out.println("It is hot outside");
//        }
//        else if (temp>=25 && temp<=30) {
//            System.out.println("It is warm outside");
//        }
//        else {
//            System.out.println("It is cold outside");
//        }
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("You are playing a game! Press q or Q to quit ");
//        String response = scanner.next();

//        if (response.equals("q") || response.equals("Q")) {
//            System.out.println("Quit game");
//        }
//        else {
//            System.out.println("In game");
//
//        if (!response.equals("q") || !response.equals("Q")) {
//            System.out.println("In game");
//        }
//        else {
//            System.out.println("Quit game");
//        }


        //While loop

        Scanner scanner = new Scanner(System.in);
        String name = "";

        while(name.isBlank()) {
            System.out.println("Enter your name: ");
            name = scanner.nextLine();
        }
        System.out.println("Hello " + name);
    }
}
