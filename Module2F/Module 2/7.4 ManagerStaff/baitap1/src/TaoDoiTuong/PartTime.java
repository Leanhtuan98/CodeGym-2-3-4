package TaoDoiTuong;

public class PartTime extends NhanVien{
     private double soBuoi;

    public PartTime(double soBuoi) {
        this.soBuoi = soBuoi;
    }

    public PartTime(String name, int age, String gender, double soBuoi) {
        super(name, age, gender);
        this.soBuoi = soBuoi;
    }

    @Override
    public double salary() {
        return soBuoi* 300;
    }
}
