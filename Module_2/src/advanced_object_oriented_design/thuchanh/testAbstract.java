package advanced_object_oriented_design.thuchanh;


import advanced_object_oriented_design.thuchanh.animal_interface_test.Animal;

public class testAbstract extends Animal {
    public float test (int value) {
        long a= 1;
        return 1.0f;
    }
    public double test (long value) {
        return 1.0;
    }

    @Override
    public String makeSound() {
        return null;
    }

    public static void main(String[] args) {
        testAbstract testAbstract=new testAbstract();
        System.out.println(testAbstract.test(1));
    }
}
