package inheritance.baitap;

import inheritance.thuchanh.Circle;

public class Cylinder extends Circle {
    private double height = 1;
    Cylinder () {
    }
    Cylinder (double radius, String color, boolean filled,double height) {
        super(radius,color,filled);
        this.height = height;
    }
    public double getHeight () {
        return this.height;
    }
    public void setHeight (double height) {
        this.height = height;
    }
    @Override
    public double getArea() {
        return 2*Math.PI*getRadius()*(getRadius()*getHeight());
    }
    public double getVolume () {
        return Math.PI*Math.pow(getRadius(),2)*getHeight();
    }
    @Override
    public String toString() {
        return "A Cylinder with radius = "
                + getRadius()
                + " and height = "
                + getHeight()
                + ", which is a subclass of "
                + super.toString();
    }

    public static void main(String[] args) {
        Cylinder cylinder1 = new Cylinder(10,"Grey",true,50);
        System.out.println(cylinder1);
    }
}
