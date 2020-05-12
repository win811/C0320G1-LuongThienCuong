package Array.baitap.IllegalTriangleException;

import java.util.Scanner;

public class TestIllegalTriangleException {
    static Scanner input = new Scanner(System.in);

    static boolean checkMinus(int value) {
        return value < 0;
    }

    static void inputValue(int[] triangle) {

        System.out.print("Edge 1 : ");
        triangle[0] = Integer.parseInt(input.nextLine());
        if (checkMinus(triangle[0])) {
            System.err.println("Bạn đã dính lỗi IllegalTriangleException");
            return;
        } else {
            System.out.print("Edge 2 : ");
            triangle[1] = Integer.parseInt(input.nextLine());
            if (checkMinus(triangle[1])) {
                System.err.println("Bạn đã dính lỗi IllegalTriangleException");
                return;
            } else {
                System.out.print("Edge 3 : ");
                triangle[2] = Integer.parseInt(input.nextLine());
                if (checkMinus(triangle[2])) {
                    System.err.println("Bạn đã dính lỗi IllegalTriangleException");
                    return;
                }
            }

        }
    }
    public static void main (String[]args){
        int[] triangle = new int[3];
        System.out.println("Input 3 edge's value : ");
        inputValue(triangle);
        System.out.println("Líu Lo");
    }
}
