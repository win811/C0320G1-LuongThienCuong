package commons;

import java.util.Scanner;

public class ValidationServices {
    private static String regex = "";
    private static Scanner input = new Scanner(System.in);

    public static String inputAndCheckId (String service) {
        if (service.equals("Villa")) {
            regex = "^SVVL-[0-9]{4}$";
            while (true) {
                System.out.println("Enter ID follow the format : SVVL-YYYY, with YYYY is number from 0 - 9 ");
                String id = input.nextLine();
                if (id.matches(regex)) {
                    return id;
                } else {
                    System.out.println("Incorrect Format!! Please try again");
                }
            }
        } else if (service.equals("House")) {
            regex = "SVHO-[0-9]{4}$";
            while (true) {
                System.out.println("Enter ID follow the format : SVHO-YYYY, YYYY is number from 0 - 9 ");
                String id = input.nextLine();
                if (id.matches(regex)) {
                    return id;
                } else {
                    System.out.println("Incorrect Format!! Please try again");
                }
            }
        } else {
            regex = "SVRO-[0-9]{4}$";
            while (true) {
                System.out.println("Enter ID follow the format : SVRO-YYYY, YYYY is number from 0 - 9 ");
                String id = input.nextLine();
                if (id.matches(regex)) {
                    return id;
                } else {
                    System.out.println("Incorrect Format!! Please try again");
                }
            }
        }
    }

    public static String inputAndCheckNameService () {
        System.out.println("Enter Name Of Service : ");
        String name = input.nextLine().toLowerCase().trim();
        String resultString = "";
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != ' ') {
                if (i == 0 || name.charAt(i - 1) == ' ') {
                    resultString += Character.toUpperCase(name.charAt(i));
                    continue;
                }
            } else if (name.charAt(i + 1) == ' '){
                continue;
            }
            resultString += name.charAt(i);
        }
        return resultString;
    }

     public static String inputAndCheckAreaUse () {

        while (true) {
            try {
                System.out.println("Enter Area Use: ");
                double areaUse = Double.parseDouble(input.nextLine());
                if (areaUse > 30) {
                    return Double.toString(areaUse);
                } else {
                    System.out.println("Area use must be higher than 30, please try again!!");
                }
            } catch (Exception e) {
                System.out.println("Area use must be number,please try again!!");
            }
        }

     }


     public static String inputAndCheckRentCost () {

         while (true) {
             try {
                 System.out.println("Enter Rent Cost : ");
                 double rentCost = Double.parseDouble(input.nextLine());
                 if (rentCost > 0) {
                     return Double.toString(rentCost);
                 } else {
                     System.out.println("Rent cost must be higher than 0, please try again!!");
                 }
             } catch (Exception e) {
                 System.out.println("Rent cost must be number,please try again!!");
             }
         }

     }

    public static String inputAndCheckMaxGuest () {

        while (true) {
            try {
                System.out.println("Enter Number Of Guest : ");
                double numberOfGuest = Double.parseDouble(input.nextLine());
                if (numberOfGuest > 0 && numberOfGuest < 20) {
                    return Double.toString(numberOfGuest);
                } else {
                    System.out.println("Number of guest must be higher than 0 and lower than 20, please try again!!");
                }
            } catch (Exception e) {
                System.out.println("Rent cost must be number,please try again!!");
            }
        }

    }

    public static String inputAndCheckRentType() {
        System.out.println("Enter Rent Type : ");
        String name = input.nextLine().toLowerCase().trim();
        String resultString = "";
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != ' ') {
                if (i == 0 || name.charAt(i - 1) == ' ') {
                    resultString += Character.toUpperCase(name.charAt(i));
                    continue;
                }
            } else if (name.charAt(i + 1) == ' '){
                continue;
            }
            resultString += name.charAt(i);
        }
        return resultString;
    }

    public static String inputAndCheckAccompaniedService () {
        regex = "^(massage[-]?|karaoke[-]?|food[-]?|drink[-]?|car[-]?|)+$";
        while (true) {
            System.out.println( "Choose Accompanied Service : massage or karaoke or food or drink or car\n" +
                                "If you dont want any accompanied service enter 'NONE' ");
            String choice = input.nextLine();
            if (choice.equals("NONE")) {
                return choice;
            }else if (choice.matches(regex)) {
                return choice;
            } else {
                System.out.println("Incorrect Format!! Please try again");
            }
        }
    }

    public static String inputAndCheckRoomStandard () {
        System.out.println("Enter Room Standard : ");
        String name = input.nextLine().toLowerCase().trim();
        String resultString = "";
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != ' ') {
                if (i == 0 || name.charAt(i - 1) == ' ') {
                    resultString += Character.toUpperCase(name.charAt(i));
                    continue;
                }
            } else if (name.charAt(i + 1) == ' '){
                continue;
            }
            resultString += name.charAt(i);
        }
        return resultString;
    }

    public static String inputAndCheckConvenient () {
        System.out.println("Enter Convenient : ");
        String name = input.nextLine().toLowerCase().trim();
        String resultString = "";
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != ' ') {
                if (i == 0 || name.charAt(i - 1) == ' ') {
                    resultString += Character.toUpperCase(name.charAt(i));
                    continue;
                }
            } else if (name.charAt(i + 1) == ' '){
                continue;
            }
            resultString += name.charAt(i);
        }
        return resultString;
    }

    public static String inputAndCheckAreaPool() {

        while (true) {
            try {
                System.out.println("Enter Area Of Pool : ");
                double areaUse = Double.parseDouble(input.nextLine());
                if (areaUse > 30) {
                    return Double.toString(areaUse);
                } else {
                    System.out.println("Area of pool must be higher than 30, please try again!!");
                }
            } catch (Exception e) {
                System.out.println("Area of pool must be number,please try again!!");
            }
        }

    }

    public static String inputAndCheckFloor () {
        while (true) {
            System.out.println("Enter number of floor : ");
            int number = Integer.parseInt(input.nextLine());
            if (number > 0) {
                return Integer.toString(number);
            } else {
                System.out.println("Number of floor must be higher than 0 ");
            }
        }
    }

    public static String inputAndCheckFreeService () {
        System.out.println("Enter Free Service : ");
        String name = input.nextLine().toLowerCase().trim();
        String resultString = "";
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != ' ') {
                if (i == 0 || name.charAt(i - 1) == ' ') {
                    resultString += Character.toUpperCase(name.charAt(i));
                    continue;
                }
            } else if (name.charAt(i + 1) == ' '){
                continue;
            }
            resultString += name.charAt(i);
        }
        return resultString;
    }

}
