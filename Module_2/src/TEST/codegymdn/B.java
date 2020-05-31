package TEST.codegymdn;


import TEST.codegymhn.A;

public class B extends A {

    public void testB() {
    }

}
class testTheory {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        System.out.println(b.X);
        A.changeX();
        System.out.println(b.X);
        b.testStatic();
        b.changeY();
        b.callTestPrivate();

    }
}
