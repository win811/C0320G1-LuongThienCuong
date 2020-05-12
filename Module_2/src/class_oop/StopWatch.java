package class_oop;

import java.util.Date;

public class StopWatch {
    private Date startTime;
    private Date endTime;
    StopWatch () {
        this.startTime = new Date();
    }
    void start () {
        this.startTime = new Date();
    }
    void stop () {
        this.endTime = new Date();
    }
    double getElapsedTime() {
        return this.endTime.getTime() - this.startTime.getTime();
    }

    public static void main(String[] args) {
        int temp = 0;
        StopWatch watch = new StopWatch();
        watch.start();
        System.out.println(watch.startTime);
        for (int i = 0; i<5000;i++ ) {
            temp++;
        }
        watch.stop();
        System.out.println(watch.endTime);
        System.out.println(watch.getElapsedTime());
    }
}
