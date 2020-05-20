package advanced_object_oriented_design.SHAPE;

import advanced_object_oriented_design.baitap.interface_resizeable.Resizeable;

public class Rectangle extends Shape implements Resizeable {
    private double width = 1;
    private double length = 1;
    public Rectangle () {
    }
    public Rectangle (double width,double length) {
        this.width = width;
        this.length = length;
    }
    public Rectangle (double width,double length,String color, boolean filled) {
        super(color,filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea () {
        return this.length * this.width;
    }
    @Override
    public double getPerimeter () {
        return 2* (this.width + this.length);
    }
    @Override
    public String toString() {
        return "A Rectangle with width = "
                + getWidth()
                + " and length = "
                + getLength()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        double newWidth = this.getWidth()*(1 + percent/100);
        double newLength = this.getLength()* (1 + percent/100);
        this.setWidth(Math.round(newWidth*100.0)/100.0);
        this.setLength(Math.round(newLength*100.0)/100.0);
    }
}

