package advanced_object_oriented_design.SHAPE;

import advanced_object_oriented_design.baitap.interface_colorable.Colorable;
import advanced_object_oriented_design.baitap.interface_resizeable.Resizeable;

public class Circle extends Shape implements Resizeable, Comparable<Circle> {
    private double radius = 0.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius,String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return this.radius * this.radius * Math.PI;
    }
    @Override
    public double getPerimeter() {
        return 2 * this.radius * Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius = "
                + this.getRadius()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        double newRadius = this.getRadius()*(1 + percent/100);
        this.setRadius(Math.round(newRadius*100.0)/100.0);
    }

    @Override
    public int compareTo(Circle circle) {
        return (int) (this.getRadius() - circle.getRadius());
    }
}