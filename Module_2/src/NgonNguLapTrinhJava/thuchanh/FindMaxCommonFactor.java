package NgonNguLapTrinhJava.thuchanh;

import java.util.Scanner;

public class FindMaxCommonFactor {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input first number : ");
        int number1 = Integer.parseInt(input.nextLine());
        System.out.print("Input second number : ");
        int number2 = Integer.parseInt(input.nextLine());

        if (number1 == 0 && number2 == 0) {
            System.out.println("There is no max common factor");
        } else if (number1 == 0 || number2 == 0) {
            if (number1 == 0) {
                System.out.println("Max common factor is : " + Math.abs(number2));
            } else {
                System.out.println("Max common factor is : " + Math.abs(number1));
            }
        } else {
            for (int i = number1 ; i > 0 ; i--) {
                if (number2 % i == 0 && number1 % i == 0) {
                    System.out.println("Max common factor is : " + i);
                    break;
                }
            }
        }
    }

}
