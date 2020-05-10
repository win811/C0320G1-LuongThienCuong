package Array.baitap;

import Array.MultiArray;

import java.util.Scanner;

public class SumColArray {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] array = MultiArray.create();
        MultiArray.inputValue(array);
        MultiArray.print(array);
        System.out.print("\nInput index of column need to be sum : ");
        int indexCol = Integer.parseInt(input.nextLine());
        int sum = 0;
        for (int[] row : array) {
            sum += row[indexCol - 1];
        }
        System.out.println("Sum of column of array is : " + sum);
    }
}
