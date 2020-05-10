package Array;

import java.util.Scanner;

public class SingleArray {
    public static Scanner input = new Scanner(System.in);
    public static int[] create () {
        int size = Integer.parseInt(input.nextLine());
        return new int[size];
    }
    public static void inputValue (int[] array) {
        for (int i = 0 ; i < array.length ; i++) {
            System.out.print("Element " + (i+1) + " : " );
            array[i] = Integer.parseInt(input.nextLine());
        }
    }
    public static void print (int[] array ) {
        for (int value : array) {
            System.out.print(value + "  ");
        }
    }
}
