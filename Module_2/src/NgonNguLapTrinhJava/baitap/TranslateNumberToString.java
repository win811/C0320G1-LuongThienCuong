package NgonNguLapTrinhJava.baitap;

import java.util.Scanner;

public class TranslateNumberToString {
    public static String translateLength1 (String number) {
        switch (number) {
            case "1" :
                return "one";
            case "2" :
                return "two";
            case "3" :
                return "three";
            case "4" :
                return "four";
            case "5" :
                return "five";
            case "6" :
                return "six";
            case "7" :
                return "seven";
            case "8" :
                return "eight";
            case "9" :
                return "nine";
            default:
                return "";
        }
    }
    public static String translateLength2 (String number) {
        String[] tempArr = number.split("");
        switch (tempArr[0]) {
            case "1" :
                switch (tempArr[1]) {
                    case "0" :
                        return "ten";
                    case "1" :
                        return "eleven";
                    case "2" :
                        return "twelve";
                    case "3" :
                        return "thirteen";
                    case "5" :
                        return "fifteen";
                    default:
                        return translateLength1(tempArr[1]) + "teen";
                }
            case "2" :
                return "twenty" + translateLength1(tempArr[1]);
            case "3" :
                return "thirty" + translateLength1(tempArr[1]);
            case "5" :
                return "fifty" + translateLength1(tempArr[1]);
            default:
                return translateLength1(tempArr[0]) + "ty" + translateLength1(tempArr[1]);
        }
    }
    public static String translateLength3 (String number) {
        String[] tempArr = number.split("");
        String tempArr2 = tempArr[1] + tempArr[2];
        return translateLength1(tempArr[0]) + "hundred" + translateLength2(tempArr2);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Number: ");
        String number = scanner.nextLine();
        switch (number.length()) {
            case 1 :
                System.out.println(translateLength1(number));
                break;
            case 2 :
                System.out.println(translateLength2(number));
                break;
            case 3 :
                System.out.println(translateLength3(number));
                break;
        }
    }
}
