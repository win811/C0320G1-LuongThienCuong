package NgonNguLapTrinhJava.thuchanh;

import java.util.Scanner;

public class FindDateInMonth {

    public static int getDateInMonth (int month,int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
                    return 29;
                else
                    return 28;
            default:
                return -1;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Month");
        int month = scanner.nextInt();
        System.out.println("Input Year");
        int year = scanner.nextInt();
        System.out.println("Date in this month-year is : " + getDateInMonth(month,year) );
    }
}
