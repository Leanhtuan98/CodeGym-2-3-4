package KhoiTaoDoiTuong;

public class FullTime extends NhanVien{
    private double heSoLuong;

    public FullTime(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public FullTime(String name, int age, String gender, double heSoLuong) {
        super(name, age, gender);
        this.heSoLuong = heSoLuong;
    }

    @Override
    public double salary() {
        return heSoLuong * 5000000;
    }

    @Override
    public String toString() {
        return "FullTime{" +
                "heSoLuong=" + heSoLuong +
                '}' + super.toString();
    }
}
