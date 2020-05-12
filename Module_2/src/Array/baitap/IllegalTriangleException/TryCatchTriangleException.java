package Array.baitap.IllegalTriangleException;

//import Array.SingleArray;

import java.util.Scanner;


public class TryCatchTriangleException {
   static Scanner input = new Scanner(System.in);

    static void checkMinus (int value) throws IllegalTriangleException {
        if (value < 0) {
            throw new IllegalTriangleException();
        }
    }
    static void checkEdge (int[] triangle) throws IllegalTriangleException {
        int a = triangle[0];
        int b = triangle[1];
        int c= triangle[2];
        if (a + b <= c || b + c <= a || a + c <= b) {
            throw new IllegalTriangleException();
        }
    }
    static void inputValue (int[] triangle ) throws IllegalTriangleException {
        System.out.print("Edge 1 : ");
        triangle[0] = Integer.parseInt(input.nextLine());
        checkMinus(triangle[0]);
        System.out.print("Edge 2 : ");
        triangle[1] = Integer.parseInt(input.nextLine());
        checkMinus(triangle[1]);
        System.out.print("Edge 3 : ");
        triangle[2] = Integer.parseInt(input.nextLine());
        checkMinus(triangle[2]);
        checkEdge(triangle);
    }

    public static void main(String[] args) {
        int[] triangle = new int[3];
        System.out.println("Input 3 edge's value : ");
        try {
            inputValue(triangle);
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Líu lo");
        }
    }
}
