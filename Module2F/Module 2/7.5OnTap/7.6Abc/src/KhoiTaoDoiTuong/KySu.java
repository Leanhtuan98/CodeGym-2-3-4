package KhoiTaoDoiTuong;

public  class KySu extends NhanVien{
    private double heSo;

    public KySu() {
    }

    public KySu(double heSo) {
        this.heSo = heSo;
    }

    public KySu(int id, String name, int age, String gender, double heSo) {
        super(id, name, age, gender);
        this.heSo = heSo;
    }

    @Override
    public double salary() {
        return heSo * 500;
    }

    @Override
    public String toString() {
        return "KySu{" +
                "heSo=" + heSo +
                '}';
    }
}
