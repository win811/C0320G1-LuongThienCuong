package class_oop;

public class Fan {
    private int id;
    private int speed = 1;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    Fan (int id){
        this.id = id;
    }

    int getSpeed () {
        return this.speed;
    }
    void setSpeed (int speed) {
        this.speed = speed;
    }
    boolean isOn () {
        return this.on;
    }
    void setOn (boolean status) {
        this.on = status;
    }
    double getRadius () {
        return this.radius;
    }
    void setRadius (double radius) {
        this.radius = radius;
    }
    String getColor () {
        return this.color;
    }
    void setColor (String color) {
        this.color = color;
    }
    @Override
    public String toString() {
        if (isOn()) {
            return  "-Fan " + this.id  +" is ON-" + "\nSpeed : " + this.speed + "\nColor : " + this.color + "\nRadius : " + this.radius;
        }
        return "-Fan " + this.id  +" is OFF-";
    }

    public static void main(String[] args) {
//        final int SLOW = 1;
        final int MEDIUM = 2;
        final int FAST = 3;
        Fan fan1 = new Fan(1);
        Fan fan2 = new Fan(2);
        System.out.println(fan1);
        fan1.setOn(true);
        fan1.setSpeed(FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        System.out.println(fan1);
        fan2.setSpeed(MEDIUM);
        fan2.setRadius(5);
        System.out.println(fan2);
    }
}

