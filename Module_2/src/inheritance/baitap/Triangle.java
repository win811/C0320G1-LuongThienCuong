package inheritance.baitap;


import inheritance.thuchanh.Shape;

import java.util.Scanner;

public class Triangle extends Shape {
    static Scanner input = new Scanner(System.in);
    private double side1 = 1;
    private double side2 = 1;
    private double side3 = 1;
    public Triangle () {};
    public Triangle (double side1,double side2, double side3,String color,boolean filled) {
        super(color,filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public double getSide1 () {
        return this.side1;
    }
    public void setSide1 (double side1) {
        this.side1 = side1;
    }
    public double getSide2 () {
        return this.side2;
    }
    public void setSide2 (double side2) {
        this.side2 = side2;
    }
    public double getSide3 () {
        return this.side3;
    }
    public void setSide3 (double side3) {
        this.side3 = side3;
    }
    public double getArea () {
        double a = getSide1();
        double b = getSide2();
        double c = getSide3();
        double p = (a + b + c)/2;
        return Math.sqrt(p*(p - a)*(p - b)*(p - c));
    }
    public double getPerimeter() {
        return getSide1() + getSide2() + getSide3();
    }
    @Override
    public String toString () {
        return "A Triangle with edge : "
                + getSide1() + "-" + getSide2() + "-" + getSide3()
                + "\nArea is : " + getArea()
                + "\nPerimeter is : " + getPerimeter()
                + "\nwhich is a subclass of "
                + super.toString();
    }
    public static boolean checkMinus(double value) {
        return value < 0;
    }
    public static boolean checkSum(double[] triangle) {
        double a = triangle[0];
        double b = triangle[1];
        double c = triangle[2];
        return ((a + b <= c) || (b + c <= a) || (a + c <= b));
    }

    public static boolean checkInputValue (double[] triangle) {
        System.out.print("Edge 1 : ");
        triangle[0] = Double.parseDouble(input.nextLine());
        if (checkMinus(triangle[0])) {
            System.out.println("Value of edge can not be minus");
            return false;
        } else {
            System.out.print("Edge 2 : ");
            triangle[1] = Double.parseDouble(input.nextLine());
            if (checkMinus(triangle[1])) {
                System.out.println("Value of edge can not be minus");
                return false;
            } else {
                System.out.print("Edge 3 : ");
                triangle[2] = Double.parseDouble(input.nextLine());
                if (checkMinus(triangle[2])) {
                    System.out.println("Value of edge can not be minus");
                    return false;
                }
            }

        }
        return !checkSum(triangle);
    }

    public static void main(String[] args) {
        double[] triangle = new double[3];
        boolean check;
        System.out.println("-Enter value of Triangle-");
        do {
            check = checkInputValue(triangle);
        }while (!check);
        System.out.print("Enter color : ");
        String color = input.nextLine();
        System.out.print("Enter status filled : ");
        boolean filled = input.nextBoolean();
        Triangle triangle1 = new Triangle(triangle[0],triangle[1],triangle[2],color,filled);
        System.out.println(triangle1);
    }
}
