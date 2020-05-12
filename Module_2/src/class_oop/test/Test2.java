package class_oop.test;

public class Test2 extends Test {
    int c,d;
    Test2 (int c, int d) {
        this.c = c;
        this.d= d;
    }

    public static void main(String[] args) {
        Test2 t = new Test2(4,5);
        System.out.println(t.b);
    }
}
