package Array.baitap;

import Array.SingleArray;

//import java.util.Scanner;

public class MergeArray {
//    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int[] arr1;
        int[] arr2;
        int[] arr3;
        System.out.print("Enter size of array 1 : ");
        arr1 = SingleArray.create();
        System.out.println("Input value of array 1 : ");
        SingleArray.inputValue(arr1);

        System.out.print("Enter size of array 2 : ");
        arr2 = SingleArray.create();
        System.out.println("Input value of array 2 : ");
        SingleArray.inputValue(arr2);

        arr3 = new int[arr1.length + arr2.length];
        System.arraycopy(arr1,0,arr3,0,arr1.length);
        System.arraycopy(arr2,0,arr3,arr1.length,arr2.length);
        System.out.println("Value of array 3 is : ");
        for (int value : arr3) {
            System.out.print(value + "  ");
        }

    }
}
