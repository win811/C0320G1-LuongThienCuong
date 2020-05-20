package advanced_object_oriented_design.SHAPE;

import advanced_object_oriented_design.baitap.interface_colorable.Colorable;
import advanced_object_oriented_design.baitap.interface_resizeable.Resizeable;

public class Square extends Rectangle implements Resizeable, Colorable {
    double side = 1;
    public Square() {
    }
    public Square(double side) {
        super(side,side);
    }

    public Square(double side,String color, boolean filled) {
        super(side,side,color,filled);
        this.side = side;
    }

    public double getSide() {
        return this.side;
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
        this.side = side;
    }

    @Override
    public void setWidth(double width) {
        this.setSide(width);
    }

    @Override
    public void setLength(double length) {
        this.setSide(length);
    }

    @Override
    public String toString() {
        return "A Square with side = "
                + this.getSide()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        double newSide = this.getSide()* (1 + percent/100);
        this.setSide(Math.round(newSide*100.0)/100.0);
    }

    @Override
    public void howToColor() {
        System.out.println("Color all your sides");
    }
}