package TEST.codegymhn;

public class A {
    public static int X = 10;
    private int Y = 11;
    public static void testStatic() {
        System.out.println("this is static");
    }
    public static void changeX() {
        X = 100;
    }
    public  void changeY() {
        Y = 111;
    }
    private void testPrivate () {
        System.out.println("This is private with Y = " + this.Y);
    }
    public void callTestPrivate () {
        testPrivate();
    }
    public int getY () {
        return this.Y;
    }
}
