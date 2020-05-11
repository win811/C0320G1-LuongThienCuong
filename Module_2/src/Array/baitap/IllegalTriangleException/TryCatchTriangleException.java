package Array.baitap.IllegalTriangleException;

//import Array.SingleArray;

import java.util.Scanner;


public class TryCatchTriangleException {
   static Scanner input = new Scanner(System.in);

    static void checkMinus (int value) throws IllegalTriangleException {
        if (value < 0) {
            throw new IllegalTriangleException("Value can not be minus");
        }
    }
    static void checkEdge (int[] triangle) throws IllegalTriangleException {
        int a = triangle[0];
        int b = triangle[1];
        int c= triangle[2];
        if (a + b < c || b + c < a || a + c < b) {
            throw new IllegalTriangleException("Sum of 2 edge can not be lower than left edge");
        }
    }

    public static void main(String[] args) {
        int[] triangle = new int[3];
        System.out.println("Input 3 edge's value : ");
        try {
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
        } catch (IllegalTriangleException e) {
            System.err.println(e.getMessage());
        }
    }
}
