package ke_thua2;

public class Rectangle extends Shape {
    private double wight = 1.0;
    private double length = 1.0;

    public Rectangle() {
    }

    public Rectangle(double wight, double length) {
        this.wight = wight;
        this.length = length;
    } public Rectangle(double wight, double length,String color, boolean filled) {
        super(color,filled);
        this.wight = wight;
        this.length = length;
    }

    public double getWight() {
        return wight;
    }

    public void setWight(double wight) {
        this.wight = wight;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    public  double getArea() {
        return wight * this.length;
    }
    public double getPerimeter() {
        return wight * this.length;
    }

    @Override
    public String toString() {
        return "A Rectangle with width="
                + getWight()
                + " and length="
                + getLength()
                + ", which is a subclass of "
                + super.toString();
    }
}
