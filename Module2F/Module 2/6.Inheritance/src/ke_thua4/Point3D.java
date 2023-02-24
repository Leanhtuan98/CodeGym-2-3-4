package ke_thua4;

public class Point3D extends Point2D {
    private float z = 0.0f;

    public Point3D() {
    }

    public Point3D(float z) {
        this.z = z;
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ (float x, float y, float z) {
        this.setXYZ(x, y, z);
    }
    public float[] getXYZ() {
        float Arr[] = {getX(),getY(),getZ()};
        return Arr;
    }

    @Override
    public String toString() {
        return super.toString()+" Point3D{" +
                "z=" + z +
                '}' ;
    }
}
