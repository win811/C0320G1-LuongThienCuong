package Array.baitap;

import Array.SingleArray;

import java.util.Scanner;

public class DeleteElementInArray {
    static Scanner input = new Scanner(System.in);

    public static int[] delete (int[] array,int index) {
        int[] tempArray = new int[array.length - 1];
        System.arraycopy(array, 0, tempArray, 0,index);
        System.arraycopy(array,index + 1,tempArray,index,array.length - (index + 1));
        return tempArray;
    }

    public static void main(String[] args) {
        System.out.print("Enter size of array : ");
        int[] array = SingleArray.create();
        System.out.println("Input value of array : ");
        SingleArray.inputValue(array);
        System.out.println("-Single Array-");
        SingleArray.print(array);

        int index;
        while (true) {
            System.out.print("\nInput index need to be deleted : ");
            index = Integer.parseInt(input.nextLine());
            if (index >= 1 && index <= array.length) {
                break;
            }
            System.out.println("Index is out of size");
        }
        array = delete(array,index-1);
        SingleArray.print(array);

    }
}
