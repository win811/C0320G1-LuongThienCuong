package inheritance.baitap;

public class MovablePoint extends Point2D {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;
    public MovablePoint(){};
    public MovablePoint(float xSpeed,float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public MovablePoint(float x, float y,float xSpeed,float ySpeed) {
        super(x,y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public float getXSpeed () {
        return this.xSpeed;
    }
    public float getYSpeed () {
        return this.ySpeed;
    }
    public void setXSpeed (float xSpeed) {
        this.xSpeed = xSpeed;
    }
    public void setYSpeed (float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed (float xSpeed,float ySpeed) {
        setXSpeed(xSpeed);
        setYSpeed(ySpeed);
    }
    public float[] getSpeed () {
        return new float[] {getXSpeed(),getYSpeed()};
    }
    @Override
    public String toString () {
        return super.toString() + ",speed = (" + getXSpeed() + "," + getYSpeed() + ")";
    }
    public MovablePoint move() {
        return this;
    }
}
