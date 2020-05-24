package exception;

import java.util.Scanner;

public class GenderException extends Exception {

    static Scanner input = new Scanner(System.in);

    public GenderException(String message) {
        super(message);
    }

    public static String inputAndCheckGender ()  {

        while (true) {
            try {
                System.out.println("Enter Gender : male or female or unknown ");
                String gender = input.nextLine().toLowerCase().trim();
                String resultString = "";

                for (int i = 0; i < gender.length(); i++) {
                    if (gender.charAt(i) != ' ') {
                        if (i == 0 || gender.charAt(i - 1) == ' ') {
                            resultString += Character.toUpperCase(gender.charAt(i));
                            continue;
                        }
                    } else if (gender.charAt(i + 1) == ' '){
                        continue;
                    }
                    resultString += gender.charAt(i);
                }

                if (resultString.equals("Male")||resultString.equals("Female")||resultString.equals("Unknown")) {
                    return resultString;
                } else {
                    throw new EmailException("Incorrect Gender Format!! Please Try Again");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

}
