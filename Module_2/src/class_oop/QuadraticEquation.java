package class_oop;

import java.util.Scanner;

public class QuadraticEquation {
    static Scanner input = new Scanner(System.in);
    double a,b,c;
    QuadraticEquation (double a,double b ,double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    double getDiscriminant() {
        return b*b - (4*a*c);
    }

    void getRoot () {
        double root1;
        double root2;
        if (getDiscriminant() > 0) {
            root1 = (-b - Math.sqrt(getDiscriminant())) / 2 * a;
            root2 = (-b + Math.sqrt(getDiscriminant())) / 2 * a;
            System.out.println("The Equation has two root : " + root1 + " and " + root2);
        } else if (getDiscriminant() == 0) {
            System.out.println("The Equation has one root : " + (-b / (2 * a)));
        }else {
            System.out.println("The Equation has no real roots");
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter a : ");
        double a = input.nextDouble();
        System.out.print("Enter b : ");
        double b = input.nextDouble();
        System.out.print("Enter c : ");
        double c = input.nextDouble();
        QuadraticEquation equation = new QuadraticEquation(a,b,c);
        equation.getRoot();
    }
}
