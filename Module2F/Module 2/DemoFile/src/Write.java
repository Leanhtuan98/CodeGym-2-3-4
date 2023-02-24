import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Write {
   static Scanner scanner = new Scanner(System.in);
   static ArrayList<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Nhap ten: ");
        String name = scanner.nextLine();
        System.out.println("Nhap mat khau: ");
        String password = scanner. nextLine();
        Account account = new Account(name,password);

        accounts.add(account);

        try {
            FileWriter paper = new FileWriter("data");
            BufferedWriter pen = new BufferedWriter(paper);
            for (int i = 0; i < accounts.size() ; i++) {
                pen.write(accounts.get(i).getUserName()+","+accounts.get(i).getPassWord());

            }
            pen.close();
            paper.close();
        }catch (Exception e) {
            System.out.println("khong co");
        }

    }
}
