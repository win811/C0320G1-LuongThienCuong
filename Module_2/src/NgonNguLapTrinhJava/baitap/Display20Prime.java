package NgonNguLapTrinhJava.baitap;

import java.util.Scanner;

public class Display20Prime {

    public static boolean checkPrime (int number) {
        for (int i=2;i <= number/2;i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input amount need to be display : ");
        int amount = Integer.parseInt(input.nextLine());
        int count = 0;
        for (int number = 2; count < amount; number++) {
            if (checkPrime(number)) {
                System.out.println(number);
                count++;
            }
        }
    }
}
