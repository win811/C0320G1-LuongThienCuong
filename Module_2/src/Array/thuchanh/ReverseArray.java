package Array.thuchanh;

import Array.SingleArray;

//import java.util.Scanner;

public class ReverseArray {
//    static Scanner input = new Scanner(System.in);

    static void reverse (int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        System.out.println("*Reverse Success!*");
    }

    public static void main(String[] args) {
        int[] array;
        do {
            System.out.print("Enter size of array : ");
            array = SingleArray.create();
            if (array.length > 20)
                System.out.println("Size does not exceed 20");
        } while (array.length > 20);

        System.out.println("Input value of array : ");
        SingleArray.inputValue(array);
        System.out.println("-Single Array-");
        SingleArray.print(array);
        reverse(array);
        System.out.println("-Reversed Array-");
        SingleArray.print(array);
    }
}
