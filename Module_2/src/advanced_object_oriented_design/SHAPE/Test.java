package advanced_object_oriented_design.SHAPE;

public class Test {
    public static void main(String[] args) {
        Shape shape = new Circle(3);
        Circle circle =(Circle) shape;
        System.out.println();
    }
}
