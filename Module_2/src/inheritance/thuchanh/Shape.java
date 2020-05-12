package inheritance.thuchanh;

public class Shape {
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

    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);

        shape = new Shape("red", false);
        System.out.println(shape);

        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(3.5);
        System.out.println(circle);

        circle = new Circle(3.5,"indigo", false);
        System.out.println(circle);

        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        rectangle = new Rectangle(2.3, 5.8);
        System.out.println(rectangle);

        rectangle = new Rectangle("orange", true, 2.5, 3.8);
        System.out.println(rectangle);

        Square square = new Square();
        System.out.println(square);

        square = new Square(2.3);
        System.out.println(square);

        square = new Square("yellow", true,5.8);
        System.out.println(square);
    }
}
