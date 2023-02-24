package TaoDoiTuong;

public  class FullTime extends NhanVien{

    private double heSo;
    private double luong;

    public FullTime(double heSo, double luong) {
        this.heSo = heSo;
        this.luong = luong;
    }

    public FullTime(String name, int age, String gender, double heSo, double luong) {
        super(name, age, gender);
        this.heSo = heSo;
        this.luong = luong;
    }

    @Override
    public double salary() {
        return heSo * 500 * luong;
    }

}
