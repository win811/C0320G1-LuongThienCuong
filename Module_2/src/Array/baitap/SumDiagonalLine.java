package Array.baitap;

//import java.util.Scanner;

import Array.MultiArray;

public class SumDiagonalLine {
//    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int[][] array = MultiArray.create();
        MultiArray.inputValue(array);
        MultiArray.print(array);
        int sum = 0;
        for (int i=0; i<array.length;i++) {
            sum += array[i][i];
        }
        System.out.println("Sum of diagonal line of Matrix is : " +  sum);
    }
}
