package QuanLyNhanVien;

public class FullTime extends NhanVien  {
    private double heSo;

    public FullTime() {
    }

    public FullTime(double heSo) {
        this.heSo = heSo;
    }

    public FullTime(String name, String gender, int age, double salary, double heSo) {
        super(name, gender, age, salary);
        this.heSo = heSo;
    }

    public double getHeSo() {
        return heSo;
    }

    public void setHeSo(double heSo) {
        this.heSo = heSo;
    }

    @Override
    public String toString() {
        return "FullTime{" +
                "heSo=" + heSo +
                '}' + heSo*5000000;
    }
}
