package NgonNguLapTrinhJava.thuchanh;

import java.util.Scanner;

public class CheckPrime {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number need to be check prime");
        int number = scanner.nextInt();
        if (number < 2) {
            System.out.println(number + " is not a prime");
        } else {
            for (int i = 2; i <= number/2;i++) {
                if (number % i == 0 ) {
                    System.out.println(number + " is not a prime");
                    return;
                }
            }
            System.out.println(number + " is a prime");
        }
    }

}
