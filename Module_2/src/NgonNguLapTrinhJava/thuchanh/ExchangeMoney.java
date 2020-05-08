package NgonNguLapTrinhJava.thuchanh;

import java.util.Scanner;

public class ExchangeMoney {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input USD");
        double usd = Double.parseDouble(input.nextLine());
        double vietnam = 23000*usd;
        System.out.println("VND : " + vietnam);
    }
}
