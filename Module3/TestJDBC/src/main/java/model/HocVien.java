package model;

import java.sql.Date;
import java.time.LocalDate;

public class HocVien {
    private int id;
    private String name;
    private String address;
    private Date date;
    private String phone;
    private String email;
    private int classRoom;

    public HocVien() {
    }
// id học viên tự tăng nên k truyền tham số int id vào constructor.
    public HocVien( String name, String address, Date date, String phone, String email, int classRoom) {
        this.name = name;
        this.address = address;
        this.date = date;
        this.phone = phone;
        this.email = email;
        this.classRoom = classRoom;
    }

    public HocVien(int id, String name, String address, Date date, String phone, String email, int classRoom) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.date = date;
        this.phone = phone;
        this.email = email;
        this.classRoom = classRoom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(int classRoom) {
        this.classRoom = classRoom;
    }
}
