package Array.baitap;

//import java.util.Scanner;

import Array.MultiArray;

public class MaxValueInMultiArray {
//    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] array = MultiArray.create();
        MultiArray.inputValue(array);
        MultiArray.print(array);
        int max = array[0][0];
        for (int[] row : array) {
            for (int div : row) {
                if (div > max) {
                    max = div;
                }
            }
        }
        System.out.println("Max value in Multi Array is : " + max);
    }
}
