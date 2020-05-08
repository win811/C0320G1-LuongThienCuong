package NgonNguLapTrinhJava.thuchanh;

import java.util.Scanner;

public class Equation1 {
    public static void main(String[] args) {

        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = 0', please enter constants:");
        Scanner scanner = new Scanner(System.in);

        System.out.print("a: ");
        float a = scanner.nextFloat();

        System.out.print("b: ");
        float b = scanner.nextFloat();


        float result;
        if (a != 0) {
            result = -b / a ;
            System.out.printf("Result of equation is %f",result);
        } else {
            if (b == 0) {
                System.out.print("Equation result is countless");
            } else {
                System.out.print("No result!");
            }
        }

    }
}
