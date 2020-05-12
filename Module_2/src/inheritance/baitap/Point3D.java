package inheritance.baitap;

public class Point3D extends Point2D{
    private float z = 0.0f;
    public Point3D() {
    }
    public Point3D (float x, float y ,float z) {
        super(x,y);
        this.z = z;
    }
    public float getZ () {
        return this.z;
    }
    public void setZ (float z) {
        this.z = z ;
    }
    public void setXYZ (float x, float y, float z) {
        super.setXY(x,y);
        setZ(z);
    }
    public float[] getXYZ () {
        return new float[] {getX(),getY(),getZ()};
    }
    @Override
    public String toString () {
        return "(" + getX() + "," + getY() + "," + getZ() + ")";
    }

    public static void main(String[] args) {
        Point3D point3d = new Point3D(5.5f,6.6f,7.7f);
        System.out.println(point3d);
    }
}
