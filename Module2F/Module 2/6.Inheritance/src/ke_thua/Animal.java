package ke_thua;

public class Animal {
    // Thuoc tinh
    private String name;
    private int age = 10;
    private String gender;
    private float weight;

    // constructor ko tham so
    public Animal() {
    }
    // constructor co 2 tham so

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }


    // phuong thuc

    public void eat() {
        System.out.println("an co");
    }

    public void run() {
        System.out.println("chay ");
    }

    public void say() {
        System.out.println("abc");
    }

    // vi thuoc tinh la private nen phai co getter va setter

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
