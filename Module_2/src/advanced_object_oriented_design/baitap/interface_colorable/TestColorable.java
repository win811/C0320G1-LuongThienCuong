package advanced_object_oriented_design.baitap.interface_colorable;


import advanced_object_oriented_design.SHAPE.Circle;
import advanced_object_oriented_design.SHAPE.Rectangle;
import advanced_object_oriented_design.SHAPE.Shape;
import advanced_object_oriented_design.SHAPE.Square;


public class TestColorable {
    public static void main(String[] args) {
        Shape[] array = new Shape[3];
        array[0] = new Circle(10,"red",true);
        array[1] = new Rectangle(10,10,"blue",true);
        array[2] = new Square(10,"yellow",true);
        for (Shape shape : array) {
            if (shape instanceof Colorable) {
                ((Colorable) shape).howToColor();
                continue;
            }
            System.out.println(shape.getArea());
        }

    }
}
