package Array.baitap;

//import Array.MultiArray;
import Array.SingleArray;

//import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        int[] array;
        SingleArray singleArr = new SingleArray();
        System.out.print("Enter Size : ");
        array = singleArr.create();
        System.out.println("Input value : ");
        singleArr.inputValue(array);
    }
}
