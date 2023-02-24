package Bai1;

import java.io.FileReader;
import java.io.IOException;

public class ReadFileByFileReader {
    public static void main(String[] args) {
        try{
            FileReader reader = new FileReader("demo.txt");
            int i;
            while ((i=reader.read()) !=-1) {
                System.out.println((char) i);
            }
            reader.close();

        }catch (IOException e) {
            e.printStackTrace();

        }

    }
}
