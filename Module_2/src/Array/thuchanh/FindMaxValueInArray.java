package Array.thuchanh;

import java.util.Scanner;

public class FindMaxValueInArray {
    static int[] getSize () {
        int size;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size : ");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Size should not exceed 20");
        } while (size > 20);
        return new int[size];
    }

    static void inputValue (int[] array) {
        Scanner input = new Scanner(System.in);
        for (int i = 0 ; i < array.length; i++) {
            System.out.print("Enter element " + (i + 1) + " : ");
            array[i] = Integer.parseInt(input.nextLine());
        }
    }

    static void printArray (int[] array) {
        System.out.print("Property list: ");
        for(int i:array) {
            System.out.print(i+"\t");
        }
        System.out.println();
    }

    static void printMaxValue (int[] array) {
        int max = array[0];
        int index = 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                index = i + 1;
            }
        }
        System.out.println("The largest property value in the list is " + max + " ,at position " + index);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array = getSize();
        inputValue(array);
        printArray(array);
        printMaxValue(array);

    }
}
