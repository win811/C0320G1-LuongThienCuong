package NgonNguLapTrinhJava.thuchanh;

import java.util.Scanner;

public class FindValueInArray {

    public static String FindIndexInArray (String[] array,String value) {
        for (int i = 0; i < array.length; i++) {
            if (value.equals(array[i]) ) {
                return "Position of the students " + value + " is: " + (i + 1);
            }
        }
        return "Not found " + value + " in the list.";
    }
    public static void main(String[] args) {
     String a="An";
     String b="Cuong";
        System.out.println( a.compareTo(b));
    }
}
