package NgonNguLapTrinhJava.thuchanh;

import java.util.Scanner;

public class DrawMenu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = 1;
        while (choice != 0) {
            System.out.print("Menu" + '\n' + "1. Draw the triangle" + '\n' + "2. Draw the square" + '\n' +
                    "3. Draw the rectangle" + '\n' + "4.isosceles triangle " + '\n' + "0. Exit" + '\n' + "Enter your choice: ");
            choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Draw the triangle");
                    System.out.println("******");
                    System.out.println("*****");
                    System.out.println("****");
                    System.out.println("***");
                    System.out.println("**");
                    System.out.println("*");
                    break;
                case 2:
                    System.out.println("Draw the square");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    break;
                case 3:
                    System.out.println("Draw the rectangle");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    break;
                case 4:
                    System.out.println("Draw the isosceles triangle");
                    System.out.println("     *     ");
                    System.out.println("    ***    ");
                    System.out.println("   *****   ");
                    System.out.println("  *******  ");
                    System.out.println(" ********* ");
                    System.out.println("***********");
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
