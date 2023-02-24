package Bai1;

import java.io.FileWriter;
import java.io.IOException;

// Bài 1: Sao chép dữ liệu từ file input.txt sang file Output.txt.
// Sử dụng hai cách : + Đọc file text (File Reader)
//                    + Đọc file nhị phân (File InputSteam/FileOutPutStream.
public class WriteToFile {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("demo.txt");
            writer.write("Viet vao demo");


            writer.close();
            System.out.println("Viet vao demo thanh cong");

        }catch (IOException e) {
            System.out.println("viet vao demo that bai");
            e.printStackTrace();
        }
    }
}

