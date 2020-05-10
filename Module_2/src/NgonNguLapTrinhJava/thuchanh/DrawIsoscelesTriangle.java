package NgonNguLapTrinhJava.thuchanh;

import java.util.Scanner;

public class DrawIsoscelesTriangle {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        int row = 5;
        int col = 2*row - 1;
        String character = "*";
        int amount;
        int startIndex;

        for (int i = 0 ; i < row ;i++) {
            amount = 2*i + 1;
            startIndex = col/2 - i;
            for (int j = 0; j < col; j++) {
                if (j == startIndex) {
                    for (int z = 0; z < amount; z++) {
                        System.out.print(character);
                    }
                    j += amount - 1;
                    continue;
                }
                System.out.print(" ");
            }
            System.out.println();
        }

    }
}
