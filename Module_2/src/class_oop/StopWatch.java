package class_oop;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class StopWatch {
    static Random rd = new Random();
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

    static void SelectionSort (int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
//        int[] array = new int[100000];
//        StopWatch watch = new StopWatch();
//        for (int i = 0; i<array.length;i++ ) {
//            array[i] = rd.nextInt(1000);
//        }
//        watch.start();
//        System.out.println(watch.startTime);
//        SelectionSort(array);
//        watch.stop();
//        System.out.println(watch.endTime);
//        System.out.println(watch.getElapsedTime());
        String str = "01/01/1997";
        Date date = new Date(str);
        Date date2 = new Date();
        double age = (date2.getTime() - date.getTime())/1000/60/60/24/30/12;
        System.out.println(age);

    }
}
