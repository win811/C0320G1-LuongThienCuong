package commons;

import java.util.Scanner;

public class ValidationServices {
    private static String regex = "";
    private static Scanner input = new Scanner(System.in);

    public static String inputAndCheckId (String service) {
        if (service.equals("Villa")) {
            regex = "^SVVL-[0-9]{4}$";
            while (true) {
                System.out.println("Enter ID Villa follow the format : SVVL-YYYY, with YYYY is number from 0 - 9 ");
                String id = input.nextLine();
                if (id.matches(regex)) {
                    return id;
                } else {
                    System.out.println("Incorrect Format!! Please try again");
                }
            }
        } else if (service.equals("House")) {
            regex = "^SVHO-[0-9]{4}$";
            while (true) {
                System.out.println("Enter ID House follow the format : SVHO-YYYY, YYYY is number from 0 - 9 ");
                String id = input.nextLine();
                if (id.matches(regex)) {
                    return id;
                } else {
                    System.out.println("Incorrect Format!! Please try again");
                }
            }
        } else if (service.equals("Room")){
            regex = "^SVRO-[0-9]{4}$";
            while (true) {
                System.out.println("Enter ID Room follow the format : SVRO-YYYY, YYYY is number from 0 - 9 ");
                String id = input.nextLine();
                if (id.matches(regex)) {
                    return id;
                } else {
                    System.out.println("Incorrect Format!! Please try again");
                }
            }
        } else if (service.equals("Customer")) {
            regex = "^C-[0-9]{4}$";
            while (true) {
                System.out.println("Enter ID Customer follow the format : C-YYYY, YYYY is number from 0 - 9 ");
                String id = input.nextLine();
                if (id.matches(regex)) {
                    return id;
                } else {
                    System.out.println("Incorrect Format!! Please try again");
                }
            }
        } else {
            regex = "^E-[0-9]{4}$";
            while (true) {
                System.out.println("Enter ID Employee follow the format : C-YYYY, YYYY is number from 0 - 9 ");
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
        String rentType = input.nextLine().toLowerCase().trim();
        String resultString = "";
        for (int i = 0; i < rentType.length(); i++) {
            if (rentType.charAt(i) != ' ') {
                if (i == 0 || rentType.charAt(i - 1) == ' ') {
                    resultString += Character.toUpperCase(rentType.charAt(i));
                    continue;
                }
            } else if (rentType.charAt(i + 1) == ' '){
                continue;
            }
            resultString += rentType.charAt(i);
        }
        return resultString;
    }

    public static String inputAndCheckAccompaniedService () {
        regex = "^(massage[-]?|karaoke[-]?|food[-]?|drink[-]?|car[-]?|)+$";
        while (true) {
            System.out.println( "Choose Accompanied Service follow the format (service-service) or : massage or karaoke or food or drink or car\n" +
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
        String roomStandard = input.nextLine().toLowerCase().trim();
        String resultString = "";
        for (int i = 0; i < roomStandard.length(); i++) {
            if (roomStandard.charAt(i) != ' ') {
                if (i == 0 || roomStandard.charAt(i - 1) == ' ') {
                    resultString += Character.toUpperCase(roomStandard.charAt(i));
                    continue;
                }
            } else if (roomStandard.charAt(i + 1) == ' '){
                continue;
            }
            resultString += roomStandard.charAt(i);
        }
        return resultString;
    }

    public static String inputAndCheckConvenient () {
        System.out.println("Enter Convenient : ");
        String convenient = input.nextLine().toLowerCase().trim();
        String resultString = "";
        for (int i = 0; i < convenient.length(); i++) {
            if (convenient.charAt(i) != ' ') {
                if (i == 0 || convenient.charAt(i - 1) == ' ') {
                    resultString += Character.toUpperCase(convenient.charAt(i));
                    continue;
                }
            } else if (convenient.charAt(i + 1) == ' '){
                continue;
            }
            resultString += convenient.charAt(i);
        }
        return resultString;
    }

    public static String inputAndCheckAreaPool() {

        while (true) {
            try {
                System.out.println("Enter Area Of Pool : ");
                double areaPool = Double.parseDouble(input.nextLine());
                if (areaPool > 30) {
                    return Double.toString(areaPool);
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
            int floor = Integer.parseInt(input.nextLine());
            if (floor > 0) {
                return Integer.toString(floor);
            } else {
                System.out.println("Number of floor must be higher than 0 ");
            }
        }
    }

    public static String inputAndCheckFreeService () {
        System.out.println("Enter Free Service : ");
        String freeService = input.nextLine().toLowerCase().trim();
        String resultString = "";
        for (int i = 0; i < freeService.length(); i++) {
            if (freeService.charAt(i) != ' ') {
                if (i == 0 || freeService.charAt(i - 1) == ' ') {
                    resultString += Character.toUpperCase(freeService.charAt(i));
                    continue;
                }
            } else if (freeService.charAt(i + 1) == ' '){
                continue;
            }
            resultString += freeService.charAt(i);
        }
        return resultString;
    }

    public static String inputAndCheckPhoneNumber () {
        regex = "^0[0-9]{9}$";
        while (true) {
            System.out.println("Enter number phone follow the format : 0XXXXXXXXX");
            String phoneNumber = input.nextLine();
            if (phoneNumber.matches(regex)) {
                System.out.println(phoneNumber);
                return phoneNumber;
            } else {
                System.out.println("Incorrect Format!! Please try again");
            }
        }
    }

    public static String inputAndCheckTypeCustomer () {

        System.out.println("Enter Customer Type : ");
        String typeCustomer = input.nextLine().toLowerCase().trim();
        String resultString = "";
        for (int i = 0; i < typeCustomer.length(); i++) {
            if (typeCustomer.charAt(i) != ' ') {
                if (i == 0 || typeCustomer.charAt(i - 1) == ' ') {
                    resultString += Character.toUpperCase(typeCustomer.charAt(i));
                    continue;
                }
            } else if (typeCustomer.charAt(i + 1) == ' '){
                continue;
            }
            resultString += typeCustomer.charAt(i);
        }
        return resultString;
    }

    public static String inputAndCheckAddress () {
        System.out.println("Enter Address : ");
        String address = input.nextLine().toLowerCase().trim();
        String resultString = "";
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) != ' ') {
                if (i == 0 || address.charAt(i - 1) == ' ') {
                    resultString += Character.toUpperCase(address.charAt(i));
                    continue;
                }
            } else if (address.charAt(i + 1) == ' '){
                continue;
            }
            resultString += address.charAt(i);
        }
        return resultString;
    }
}
