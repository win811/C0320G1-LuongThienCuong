package NgonNguLapTrinhJava.thuchanh;

import java.util.Scanner;

public class CalculateInterest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input Money : ");
        double money = Float.parseFloat(input.nextLine());
        System.out.print("Input Month : ");
        int month = Integer.parseInt(input.nextLine());
        System.out.print("Input rate per year : ");
        double rate = Float.parseFloat(input.nextLine());
        double totalInterest = money * (rate/100/12) * month;
        System.out.println("Total Interest Money is : " + totalInterest);
    }
}
