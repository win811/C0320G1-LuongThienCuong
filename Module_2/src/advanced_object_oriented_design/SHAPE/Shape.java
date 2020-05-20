package advanced_object_oriented_design.SHAPE;

import advanced_object_oriented_design.baitap.interface_resizeable.Resizeable;

public abstract class Shape {
    private String color = "green";
    private boolean filled = true;
    public Shape () {
    }
    public Shape (String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    public String getColor () {
        return this.color;
    }
    public boolean isFilled () {
        return this.filled;
    }
    public void setColor (String color) {
        this.color = color;
    }
    public void setFilled (boolean filled) {
        this.filled = filled;
    }
    public String toString () {
        if (isFilled()) {
            return "A Shape with color of " + getColor() + " and filled";
        }
        return "A Shape with color of " + getColor() + " and not filled";
    }
    public abstract double getArea();
    public abstract double getPerimeter();
}
