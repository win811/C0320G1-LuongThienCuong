package NgonNguLapTrinhJava.thuchanh;

import java.util.Scanner;

public class CheckLeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input year : ");
        int year = Integer.parseInt(scanner.nextLine());
        boolean check = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
        System.out.println(check);
    }
}
