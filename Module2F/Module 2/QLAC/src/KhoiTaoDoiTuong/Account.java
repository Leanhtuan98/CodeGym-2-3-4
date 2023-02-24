package KhoiTaoDoiTuong;

public class Account {
    private int id;
    private String username;
    private String password;
    private String phone;
    private String dateBirthday;

    public Account() {
    }

    public Account(int id, String username, String password, String phone, String dateBirthday) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.dateBirthday = dateBirthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDateBirthday() {
        return dateBirthday;
    }

    public void setDateBirthday(String dateBirthday) {
        this.dateBirthday = dateBirthday;
    }
}
