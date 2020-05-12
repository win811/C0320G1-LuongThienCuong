package inheritance.thuchanh;

public class Shape {
    private String color = "green";
    private boolean filled = true;
    Shape () {
    }
    Shape (String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    String getColor () {
        return this.color;
    }
    boolean getFilled () {
        return this.filled;
    }
    void setColor (String color) {
        this.color = color;
    }
    void setFilled (boolean filled) {
        this.filled = filled;
    }
    public String toString () {
        if (this.filled) {
            return "A Shape with color of " + this.color + " and filled";
        }
        return "A Shape with color of " + this.color + " not filled";
    }
}
class Rectangle extends Shape {
    private double width = 1;
    private double length = 1;
    Rectangle () {
    }
    Rectangle (double width,double length) {
        this.width = width;
        this.length = length;
    }
    Rectangle (String color, boolean filled,double width,double length) {
        super(color,filled);
        this.width = width;
        this.length = length;
    }
    double getArea () {
        return this.length * this.width;
    }
    double getPerimeter () {
        return 2* (this.width + this.length)
    }
}