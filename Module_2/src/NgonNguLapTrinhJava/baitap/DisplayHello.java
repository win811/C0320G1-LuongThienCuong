package NgonNguLapTrinhJava.baitap;

import java.util.Scanner;

public class DisplayHello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input name : ");
        String name = scanner.nextLine();
        System.out.println("Hello: " + name);
    }
}
