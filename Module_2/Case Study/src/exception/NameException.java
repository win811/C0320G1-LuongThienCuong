package exception;

import java.util.Scanner;

public class NameException extends Exception {
    static Scanner input = new Scanner(System.in);

    public NameException(String message) {
        super(message);
    }

    public static String inputAndCheckName ()  {

        String regex = "^(([A-Z][a-z]*)\\s?)+$";
        while (true) {
            try {
                System.out.println("Enter Name Customer Follow The Format : Abc Abc ");
                String name = input.nextLine();
                if (name.matches(regex)) {
                    return name;
                } else {
                    throw new NameException("Incorrect Name Format!! Please Try Again");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }


}
