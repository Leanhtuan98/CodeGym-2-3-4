package KhoiTaoDoiTuong;

public class CongNhan extends NhanVien{
    private double soBuoi;

    public CongNhan() {
    }

    public CongNhan(double soBuoi) {
        this.soBuoi = soBuoi;
    }

    public CongNhan(int id, String name, int age, String gender, double soBuoi) {
        super(id, name, age, gender);
        this.soBuoi = soBuoi;
    }

    @Override
    public double salary() {
        return soBuoi*300;
    }

    @Override
    public String toString() {
        return "CongNhan{" +
                "soBuoi=" + soBuoi +
                '}';
    }
}
