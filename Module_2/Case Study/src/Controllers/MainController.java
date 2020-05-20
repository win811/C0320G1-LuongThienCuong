package Controllers;

import java.util.Scanner;

public class MainController {
    Scanner input = new Scanner(System.in);
    public void displayMainMenu() {
        System.out.println( "1. Add New Services" +
                            "\n2. Show Services" +
                            "\n3. Add New Customer" +
                            "\n4. Show Information of Customer" +
                            "\n5. Add New Booking" +
                            "\n6. Show Information of Employee" +
                            "\n7. Exit");
        System.out.print("Enter number of function you want to use : ");
        int choice = input.nextInt();
    }
    public void addNewServices () {
        System.out.println( "1. Add New Villa" +
                            "\n2. Add New House" +
                            "\n3. Add New Room" +
                            "\n4. Back to menu" +
                            "\n5. Exit" +
                            "\n6. Exit");
        System.out.print("Enter number of function you want to use : ");
        int choice = input.nextInt();
    }
}
