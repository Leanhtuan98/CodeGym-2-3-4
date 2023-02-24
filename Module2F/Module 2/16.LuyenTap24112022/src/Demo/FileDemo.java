package Demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) {
        File file = new File("hello.txt");
        System.out.println(file.exists());
        System.out.println(file.isAbsolute());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("BufferedWriter\n");
            writer.write("ABC\n");
            writer.write("123\n");
            writer.write("null\n");
        } catch (IOException e) {
            System.out.println("Co loi luc ghi file!");
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (true) {
                final String line = reader.readLine();
                if (line == null) break;
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File khong ton tai " +
                    "hoac co loi trong luc doc.");
            e.printStackTrace();
        }
    }
}