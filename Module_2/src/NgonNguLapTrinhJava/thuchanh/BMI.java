package NgonNguLapTrinhJava.thuchanh;

import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input Height : ");
        double height = Float.parseFloat(input.nextLine());
        System.out.print("Input Weight : ");
        double weight = Float.parseFloat(input.nextLine());
        double bmi = weight / Math.pow(height, 2);
        if (bmi < 18)
            System.out.printf("%-20.2f%s%s", bmi, "Underweight","Líu lo");
        else if (bmi < 25.0)
            System.out.printf("%-20.2f%-20s%s", bmi, "Normal","Líu lo");
        else if (bmi < 30.0)
            System.out.printf("%-20.2f%s", bmi, "Overweight");
        else
            System.out.printf("%-20.2f%s", bmi, "Obese");
    }
}
