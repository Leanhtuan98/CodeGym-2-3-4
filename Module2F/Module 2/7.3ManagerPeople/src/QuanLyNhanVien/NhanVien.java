package QuanLyNhanVien;

public abstract class NhanVien {
    private int id;
    private String name;
    private int age;
    private String address;
    private double workingDay;
    private double salary;

    public NhanVien(int id, String name, int age, String address, double workingDay, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.workingDay = workingDay;
        this.salary = salary;
    }

    public abstract double sumSalary();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(double workingDay) {
        this.workingDay = workingDay;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
