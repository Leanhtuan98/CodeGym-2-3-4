package QuanLyNhanVien;

public class PartTime extends NhanVien{
    private double soBuoi;

    public PartTime(double soBuoi) {
        this.soBuoi = soBuoi;
    }

    public PartTime(String name, String gender, int age, double salary, double soBuoi) {
        super(name, gender, age, salary);
        this.soBuoi = soBuoi;
    }

    public double getSoBuoi() {
        return soBuoi;
    }

    public void setSoBuoi(double soBuoi) {
        this.soBuoi = soBuoi;
    }

    @Override
    public String toString() {
        return "PartTime{" +
                "soBuoi=" + soBuoi +
                '}'+ soBuoi*200000;
    }
}