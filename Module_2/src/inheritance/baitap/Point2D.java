package inheritance.baitap;

public class Point2D {
    private float x = 0.0f;
    private float y = 0.0f;
    public Point2D () {
    }
    public Point2D (float x , float y) {
        this.x = x;
        this.y = y;
    }
    public static void test () {
        System.out.println("test");
    }
    public float getX () {
        return this.x;
    }
    public void setX (float x) {
        this.x = x;
    }
    public float getY () {
        return this.y;
    }
    public void setY (float y) {
        this.y = y;
    }
    public float[] getXY () {
        return new float[] {getX(), getY()};
    }
    public void setXY (float x , float y) {
        setX(x);
        setY(y);
    }
    public String toString () {
        return "(" + getX() + "," + getY() + ")";
    }

    public static void main(String[] args) {
        Point2D point2d = new Point2D(2.3f,3.3f);
        System.out.println(point2d);
    }

}
