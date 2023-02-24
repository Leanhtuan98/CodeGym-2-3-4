import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Read {
    public static void main(String[] args) {
        
        String Account = "";
        
        try {
            FileReader read = new FileReader("data");
            BufferedReader doc = new BufferedReader(read);
            while (true) {
                Account = doc.readLine();
                if (Account == null) {
                    break;
                }
                String cut[] = Account.split(",");
                String name = cut[0];
                String password = cut[1];
                Account doiTuong = new Account(name,password);
                ArrayList<Account> Mang = new ArrayList<>();
                Mang.add(doiTuong);

                for (int i = 0; i < Mang.size(); i++) {
                    System.out.println(Mang.get(i));

                }
            }
            
        } catch (Exception e) {
            System.out.println("Nhap lai");
        }
    }
}
