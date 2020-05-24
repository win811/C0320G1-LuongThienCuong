package exception;

import java.util.Scanner;

public class EmailException extends Exception {
    static Scanner input = new Scanner(System.in);

    public EmailException(String message) {
        super(message);
    }

    public static String inputAndCheckEmail ()  {

        String regex = "^[A-Za-z0-9_]+@[A-Za-z0-9_]+\\.[A-Za-z0-9_]+$";
        while (true) {
            try {
                System.out.println("Enter Email Follow The Format : abc@abc.abc ");
                String email = input.nextLine();
                if (email.matches(regex)) {
                    return email;
                } else {
                    throw new EmailException("Incorrect Email Format!! Please Try Again");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

}
