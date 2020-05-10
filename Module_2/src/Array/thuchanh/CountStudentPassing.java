package Array.thuchanh;

import Array.SingleArray;

//import java.util.Scanner;

public class CountStudentPassing {
//    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("The Application to count the number of students pass.");
        int[] array;

        do {
            System.out.print("Enter amount of student : ");
            array = SingleArray.create();
            if (array.length > 30)
                System.out.println("Size does not exceed 30");
        } while (array.length > 30);

        System.out.println("Enter mark for student's list : ");
        SingleArray.inputValue(array);

        System.out.println("-List of mark-");
        SingleArray.print(array);

        int count = 0;
        for (int value : array) {
            if (value >= 5 && value <= 10)
                count++;
        }
        System.out.print("\nThe number of students passing the exam is " + count);
    }
}
