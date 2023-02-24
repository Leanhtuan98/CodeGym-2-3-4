package ke_thua2;

public class Square  extends Rectangle{
    public Square() {
    }
    public Square(double side) {
        super(side,side);
    }

    public Square(double side,String color, boolean filled) {
        super(side, side, color, filled);
    }
    public double getSide() {
        return getWight();
    }

    public void setSide(double side) {
        setWight(side);
        setLength(side);
    }

    @Override
    public void setWight(double wight) {
        setSide(wight);
    }
    @Override
    public void setLength(double length) {
        setSide(length);
    }
    @Override
    public String toString() {
        return "A Square with side=" + getSide() + ", which is a subclass of" + super.toString();
    }
}
