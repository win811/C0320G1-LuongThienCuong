package class_oop;

import java.util.Scanner;

public class Rectangle {

    static Scanner input = new Scanner(System.in);
    double height,width;
    Rectangle (double height,double width) {
        this.height = height;
        this.width = width;
    }
    double getArea() {
        return width*height;
    }
    double getPerimeter () {
        return (width+height)*2;
    }
    String display() {
        return "Rectangle{width=" + width + ", height=" + height + "}";
    }

    public static void main(String[] args) {
        System.out.print("Enter the width: ");
        double width = input.nextDouble();
        System.out.print("Enter the height: ");
        double height = input.nextDouble();
        Rectangle rec1 = new Rectangle(height,width);
        System.out.println("Your Rectangle \n"+ rec1.display());
        System.out.println("Perimeter of the Rectangle: "+ rec1.getPerimeter());
        System.out.println("Area of the Rectangle: "+ rec1.getArea());
    }
}
