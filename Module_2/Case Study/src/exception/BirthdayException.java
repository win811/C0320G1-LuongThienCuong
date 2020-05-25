package exception;

import java.time.LocalDate;
import java.time.Period;
//import java.util.Date;
import java.util.Scanner;

public class BirthdayException extends Exception {
    static Scanner input = new Scanner(System.in);

    public BirthdayException(String message) {
        super(message);
    }

    public static String inputAndCheckBirthday18 () {
        String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";

        while (true) {
            try {
                System.out.println("Enter Birthday Follow The Format : dd/mm/yyyy ");
                String birthday = input.nextLine();
                if (birthday.matches(regex)) {
                    String[] birthdayArr = birthday.split("/");
                    int year = Integer.parseInt(birthdayArr[2]);
                    int month = Integer.parseInt(birthdayArr[1]);
                    int day = Integer.parseInt(birthdayArr[0]);
                    LocalDate birthDay = LocalDate.of(year,month,day); //specify year, month, date directly
                    LocalDate now = LocalDate.now(); //gets localDate
                    Period distance = Period.between(birthDay,now); //difference between the dates is calculated
                    int age = distance.getYears();
                    if (age >= 18) {
                        return birthday;
                    } else {
                        throw new BirthdayException("Age must be higher or equal 18");
                    }
                } else {
                    throw new BirthdayException("Incorrect Birthday Format!! Please Try Again");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }


}
