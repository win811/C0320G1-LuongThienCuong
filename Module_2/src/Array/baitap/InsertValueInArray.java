package Array.baitap;

import Array.SingleArray;

import java.util.Scanner;

public class InsertValueInArray {
    static Scanner input = new Scanner(System.in);

    static int[] insert (int[] array,int index, int value) {
        int[] tempArray = new int[array.length + 1];
        System.arraycopy(array, 0, tempArray, 0,index);
        tempArray[index] = value;
        System.arraycopy(array,index,tempArray,index+1,array.length - index);
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
            System.out.print("\nInput index need to be inserted value  : ");
            index = Integer.parseInt(input.nextLine());
            if (index >= 1 && index <= array.length + 1) {
                break;
            }
            System.out.println("Index is out of size");
        }

        System.out.print("Input value need to be inserted : ");
        int value = Integer.parseInt(input.nextLine());
        array = insert(array,index - 1,value);
        SingleArray.print(array);
    }
}
