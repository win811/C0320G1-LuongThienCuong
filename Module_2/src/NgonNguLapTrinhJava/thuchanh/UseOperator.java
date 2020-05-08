package NgonNguLapTrinhJava.thuchanh;

import java.util.Scanner;

public class UseOperator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Width");
        float width = scanner.nextFloat();
        System.out.println("Enter Height");
        float height = scanner.nextFloat();
        float result = width * height;
        System.out.println(result);
    }
}
