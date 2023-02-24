package KhoiTaoDoiTuong;

public class NhanVien {
    private static int Id;
    private int id;
    private String name;
    private int age;
    private double salary;
    private String birthDay;
    private String gender;

    public NhanVien() {
    }

    public NhanVien(String name, int age, double salary, String birthDay, String gender) {
        this.id = Id ++;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.birthDay = birthDay;
        this.gender = gender;
    }

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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", birthDay='" + birthDay + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
