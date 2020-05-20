package advanced_object_oriented_design.baitap.interface_resizeable;

import advanced_object_oriented_design.SHAPE.Circle;
import advanced_object_oriented_design.SHAPE.Rectangle;
import advanced_object_oriented_design.SHAPE.Shape;
import advanced_object_oriented_design.SHAPE.Square;

import java.util.Random;

public class TestResizeable {
    public static void main(String[] args) {
        Shape[] arrayShape = new Shape[3];
        arrayShape[0] = new Circle(10,"red",true);
        arrayShape[1] = new Rectangle(10,10,"blue",true);
        arrayShape[2] = new Square(10,"yellow",true);

        System.out.println("Before Resize : ");
        for (Shape shape : arrayShape) {
            System.out.println(shape);
        }
        Random random = new Random();
        double percent = random.nextDouble()*100;
        for (Shape shape : arrayShape ) {
            ((Resizeable)shape).resize(percent);
        }
        System.out.println("After Resize : ");
        for (Shape shape : arrayShape) {
            System.out.println(shape);
        }
    }
}
