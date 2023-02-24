package KhoiTaoDoiTuong;

public class PartTime extends NhanVien {

    private int soNgayLam;

    public PartTime(int soNgayLam) {
        this.soNgayLam = soNgayLam;
    }

    public PartTime(String name, int age, String gender, int soNgayLam) {
        super(name, age, gender);
        this.soNgayLam = soNgayLam;
    }

    @Override
    public double salary() {
        return soNgayLam * 200000;
    }

    @Override
    public String toString() {
        return "PartTime{" +
                "soNgayLam=" + soNgayLam +
                '}' + super.toString();
    }
}
