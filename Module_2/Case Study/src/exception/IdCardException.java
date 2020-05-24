package exception;

import java.util.Scanner;

public class IdCardException extends Exception {
    static Scanner input = new Scanner(System.in);

    public IdCardException(String message) {
        super(message);
    }

    public static String inputAndCheckIdCard ()  {

        String regex = "^[0-9]{9}$";
        while (true) {
            try {
                System.out.println("Enter Id Card Follow The Format : XXXXXXXXX - With X Is Number ");
                String idCard = input.nextLine();
                if (idCard.matches(regex)) {
                    return idCard;
                } else {
                    throw new IdCardException("Incorrect Id Card Format!! Please Try Again");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }


}
