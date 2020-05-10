package Array;

import java.util.Scanner;

public class MultiArray {

    static Scanner input = new Scanner(System.in);
    public static int[][] create () {
        System.out.print("Input row : ");
        int rows = Integer.parseInt(input.nextLine());
        System.out.print("Input col : ");
        int cols = Integer.parseInt(input.nextLine());
        return new int[rows][cols];
    }
    public static void inputValue (int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Input value of row " + (i + 1) + " : ");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print("Element " + (i+1)+"-"+(j+1) + " : " );
                array[i][j] = Integer.parseInt(input.nextLine());
            }
        }
    }
    public static void print (int[][] array) {
        System.out.println("-Multi Array-");
        for (int[] row : array) {
            for (int div : row) {
                System.out.print(div + "  ");
            }
            System.out.println();
        }
    }
}
