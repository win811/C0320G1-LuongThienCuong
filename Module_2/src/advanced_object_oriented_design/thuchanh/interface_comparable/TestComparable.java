package advanced_object_oriented_design.thuchanh.interface_comparable;

import advanced_object_oriented_design.SHAPE.Circle;

import java.util.Arrays;

public class TestComparable {

    public static void main(String[] args) {
        Circle[] arrayCircle = new Circle[3];
        arrayCircle[0] = new Circle(10.3,"red",true);
        arrayCircle[1] = new Circle(4.5,"blue",true);
        arrayCircle[2] = new Circle(6.7,"yellow",true);
        System.out.println("Before Sorted : ");
        for (Circle circle : arrayCircle) {
            System.out.println(circle);
        }
        Arrays.sort(arrayCircle);
        System.out.println("After Sorted : ");
        for (Circle circle : arrayCircle) {
            System.out.println(circle);
        }
    }

}
