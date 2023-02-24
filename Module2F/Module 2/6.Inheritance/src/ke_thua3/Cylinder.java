package ke_thua3;

public class Cylinder extends Circle {
    private double height = 3.0;

    public Cylinder() {
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(String color, double radius, double height) {
        super(color, radius);
        this.height = height;
    }
    public double getVolume() {
        return getArea()* height;
    }

    @Override
    public String toString() {
        return " A Cylinder{" +
                "height=" + height +
                '}' + super.toString()+" The tich"+getVolume();
    }

    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);

        cylinder = new Cylinder("red",1.0,2.0);
    }
}

