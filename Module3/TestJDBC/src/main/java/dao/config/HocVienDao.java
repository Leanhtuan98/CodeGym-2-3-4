package dao.config;

import model.HocVien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HocVienDao {

    // Tạo đối tượng connection để kết nối với CSDL
   static Connection connection = ConnectMySQL.getConnection();

    // Tạo ra các phương thức

    // Lấy ra tất cả các học viên trong List,dùng phương thức getAll().

    public static List<HocVien> getAll() {
        // Thực hiện câu lệnh SQL

        String selectAll = "select * from hocvien";

        try {
            Statement statement = connection.createStatement();

            // dùng executeQuery chỉ để lấy dữ liệu trong bảng.
            // dùng ResultSet để hứng cái giá trị được lấy từ bảng
            ResultSet resultSet =  statement.executeQuery(selectAll);
            List<HocVien> hocViens = new ArrayList<>();

            // dùng resultSet.next() để duyệt từng bản ghi của dữ liệu trả về.
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name= resultSet.getString("name");
                String address= resultSet.getString("address");
                Date date = resultSet.getDate("date");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                int idClassRoom = resultSet.getInt("idClassRoom");

                hocViens.add(new HocVien(id,name,address,date,phone,email,idClassRoom));
            }
            return hocViens;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
