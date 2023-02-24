package QuanLyNhanVien;

public class KySu extends NhanVien{
    private double payRateSalary;

    public KySu(int id, String name, int age, String address, double workingDay, double salary, double payRateSalary) {
        super(id, name, age, address, workingDay, salary);
        this.payRateSalary = payRateSalary;
    }

    public double getPayRateSalary() {
        return payRateSalary;
    }

    public void setPayRateSalary(double payRateSalary) {
        this.payRateSalary = payRateSalary;
    }

    @Override
    public double sumSalary() {
        return payRateSalary * super.getSalary() * super.getWorkingDay();
    }
}
