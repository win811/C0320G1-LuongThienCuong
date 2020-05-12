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

//    int getSpeed () {
//        return this.speed;
//    }
//    boolean getOn () {
//        return this.on;
//    }
//    double getRadius () {
//        return this.radius;
//    }
//    String getColor () {
//        return this.color;
//    }
    void setSpeed (int speed) {
        this.speed = speed;
    }
    void setOn (boolean status) {
        this.on = status;
    }
    void setRadius (double radius) {
        this.radius = radius;
    }
    void setColor (String color) {
        this.color = color;
    }
    void check() {
        if (this.on) {
            System.out.println("-Fan " + this.id  +" is ON-" + "\nSpeed : " + this.speed + "\nColor : " + this.color + "\nRadius : " + this.radius);
        } else {
            System.out.println("-Fan " + this.id  +" is OFF-");
        }
    }

    public static void main(String[] args) {
//        final int SLOW = 1;
        final int MEDIUM = 2;
        final int FAST = 3;
        Fan fan1 = new Fan(1);
        Fan fan2 = new Fan(2);
        fan1.check();
        fan1.setOn(true);
        fan1.setSpeed(FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.check();
        fan2.setSpeed(MEDIUM);
        fan2.setRadius(5);
        fan2.check();
    }
}

