package Controllers;

import Service.BookingCinema4DInterface;
import Service.CustomerInterface;
import Service.FilingCabinetsInterface;
import Service.impl.*;
import Service.ServiceInterface;
import commons.FuncWriteAndReadFileCSV;
import models.*;
import sort.NameCustomerComparator;

import java.util.*;

public class MainController {

    private static final String PATH_FILE_VILLA = "src/data/Villa.csv";
    private static final String PATH_FILE_HOUSE = "src/data/House.csv";
    private static final String PATH_FILE_ROOM = "src/data/Room.csv";
    private static final String PATH_FILE_BOOKING = "src/data/Booking.csv";
    private static final String PATH_FILE_CUSTOMER = "src/data/Customer.csv";
    private static final String PATH_FILE_EMPLOYEE = "src/data/Employee.csv";

    private ServiceInterface villaService = new VillaServiceImpl();
    private ServiceInterface houseService = new HouseServiceImpl();
    private ServiceInterface roomService = new RoomServiceImpl();
    private CustomerInterface customerService = new CustomerImpl();
//    private EmployeeService employeeService = new EmployeeServiceImpl();
    private BookingCinema4DInterface bookingCinema4DService = new BookingCinema4DImpl();
    private FilingCabinetsInterface filingCabinetsService = new FilingCabinetsImpl();

    Scanner input = new Scanner(System.in);
    public void displayMainMenu() {
        System.out.println("--------------------------------");
        System.out.println( "1. Add New Services" +
                            "\n2. Show Services" +
                            "\n3. Add New Customer" +
                            "\n4. Show Information of Customer" +
                            "\n5. Add New Booking" +
                            "\n6. Show Information of Employee" +
                            "\n7. Add booking cinema 4D" +
                            "\n8. Show booking cinema 4D" +
                            "\n9. Search Filing Cabinets of Employee" +
                            "\n10. Exit");
        System.out.print("Enter number of function you want to use : ");
        int choice = -1 ;
        try {
            choice = Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            System.out.println("Choice is not in the menu!!");
        }

        switch (choice) {
            case 1 :
                menuAddNewServices();
                break;
            case 2 :
                menuShowServices();
                break;
            case 3 :
                addNewCustomer();
                System.out.println("CSV file Customer was created successfully ! Enter to continue");
                input.nextLine();
                displayMainMenu();
                break;
            case 4 :
                showInfoCustomer();
                System.out.println("Show Information Of Customer successfully ! Enter to continue");
                input.nextLine();
                displayMainMenu();
                break;
            case 5 :
                addNewBooking();
                System.out.println("CSV file Booking was created successfully ! Enter to continue");
                input.nextLine();
                displayMainMenu();
                break;
            case 6 :
                showInfoEmployee();
                System.out.println("Show Information Of Employee successfully ! Enter to continue");
                input.nextLine();
                displayMainMenu();
                break;
            case 7 :
                addNewBookingCinema();
                System.out.println("Add new booking cinema successfully ! Enter to continue");
                input.nextLine();
                displayMainMenu();
                break;
            case 8 :
                showBookingCinema();
                System.out.println("Show Information Of Booking Cinema successfully ! Enter to continue");
                input.nextLine();
                displayMainMenu();
                break;
            case 9 :
                searchFilingCabinetsOfEmployee();
                System.out.println("Searching Filing Cabinet Successfully. Enter to continue");
                input.nextLine();
                displayMainMenu();
                break;
            case 10 :
                System.exit(0);
                break;
            default :
                System.out.print("Wrong choice,please choose again,press Enter to continue");
                input.nextLine();
                displayMainMenu();
        }
    }
// ----------------------------------------------------------------------------------------
    public void menuAddNewServices () {
        System.out.println("--------------------------------");
        System.out.println( "1. Add New Villa" +
                            "\n2. Add New House" +
                            "\n3. Add New Room" +
                            "\n4. Back to main menu" +
                            "\n5. Exit");
        System.out.print("Enter number of function you want to use : ");
        int choice = -1 ;
        try {
            choice = Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            System.out.println("Choice is not in the menu!!");
        }
        switch (choice) {
            case 1: {
                addListVillaService();
                System.out.println("CSV file Villa was created successfully ! Enter to continue");
                input.nextLine();
                menuAddNewServices();
                break;
            }
            case 2: {
                addListHouseService();
                System.out.println("CSV file House was created successfully ! Enter to continue");
                input.nextLine();
                menuAddNewServices();
                break;
            }
            case 3: {
                addListRoomService();
                System.out.println("CSV file Room was created successfully ! Enter to continue");
                input.nextLine();
                menuAddNewServices();
                break;
            }

            case 4: {
                displayMainMenu();
                break;
            }
            case 5: {
                System.exit(0);
            }
            default: {
                System.out.print("Wrong choice,please choose again,press Enter to continue ");
                input.nextLine();
                menuAddNewServices();
            }
        }
    }

    public void addListVillaService() {
        System.out.println("Enter amount of villa you want to add : ");
        int number = Integer.parseInt(input.nextLine());
        Villa villa;
        for (int i = 0; i < number;i++) {
            villa = (Villa) villaService.addNewService();
            String oldFile = FuncWriteAndReadFileCSV.readCsvFile("Villa");
            FuncWriteAndReadFileCSV.writeCsvFile(oldFile,villa);
            System.out.println("Add New Villa SuccessFully");
        }

    }
    public void addListHouseService() {
        System.out.println("Enter amount of House you want to add : ");
        int number = Integer.parseInt(input.nextLine());
        House house;
        for (int i = 0; i < number;i++) {
            house = (House) houseService.addNewService();
            String oldFile = FuncWriteAndReadFileCSV.readCsvFile("House");
            FuncWriteAndReadFileCSV.writeCsvFile(oldFile,house);
            System.out.println("Add New House SuccessFully");
        }

    }
    public void addListRoomService() {
        System.out.println("Enter amount of Room you want to add : ");
        int number = Integer.parseInt(input.nextLine());
        Room room;
        for (int i = 0; i < number;i++) {
            room = (Room) roomService.addNewService();
            String oldFile = FuncWriteAndReadFileCSV.readCsvFile("Room");
            FuncWriteAndReadFileCSV.writeCsvFile(oldFile,room);
            System.out.println("Add New Room SuccessFully");
        }
    }
// ----------------------------------------------------------------------------------------
    public void menuShowServices () {

        System.out.println( "1. Show All Villa\n" +
                            "2. Show All House\n" +
                            "3. Show All Room\n" +
                            "4. Show All Name Villa Not Duplicate\n" +
                            "5. Show All Name House Not Duplicate\n" +
                            "6. Show All Name Room Not Duplicate\n" +
                            "7. Back to main menu\n" +
                            "8. Exit");
        System.out.print("Enter your choice: ");
        int choice = -1 ;
        try {
            choice = Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            System.out.println("Choice is not in the menu!!");
        }
        switch (choice) {
            case 1: {
                showVillaService();
                System.out.println("Show Villa successfully ! Enter to continue");
                input.nextLine();
                menuShowServices();
                break;
            }
            case 2: {
                showHouseService();
                System.out.println("Show House successfully ! Enter to continue");
                input.nextLine();
                menuShowServices();
                break;
            }
            case 3: {
                showRoomService();
                System.out.println("Show Room successfully ! Enter to continue");
                input.nextLine();
                menuShowServices();
                break;
            }
            case 4: {
                showAllNameVillaNotDuplicate();
                break;
            }
            case 5: {
                showAllNameHouseNotDuplicate();
                break;
            }
            case 6: {
                showAllNameRoomNotDuplicate();
                break;
            }
            case 7: {
                displayMainMenu();
                break;
            }
            default: {
                System.out.print("Wrong choice,please choose again,press Enter to continue");
                input.nextLine();
                menuShowServices();
            }
        }
    }

    public void showVillaService() {

        String dataVilla = FuncWriteAndReadFileCSV.readCsvFile(PATH_FILE_VILLA);
        String[] villaArray = dataVilla.split("\n");
        System.out.println( "--------------------\n" +
                            "-All Villa In Resort-" +
                            "\n--------------------");
        for (int i = 0; i < villaArray.length; i++) {
            if (i == 0) {
                continue;
            }
            String[] aVilla = villaArray[i].split(",");
            Villa villa = new Villa();
            villa.setId(aVilla[0]);
            villa.setNameService(aVilla[1]);
            villa.setAreaUse(aVilla[2]);
            villa.setRentCost(aVilla[3]);
            villa.setMaxGuest(aVilla[4]);
            villa.setRentType(aVilla[5]);
            villa.setAccompaniedService(aVilla[6]);
            villa.setRoomStandard(aVilla[7]);
            villa.setConvenient(aVilla[8]);
            villa.setAreaPool(aVilla[9]);
            villa.setFloor(aVilla[10]);
            villa.showInfo();
        }

    }
    public void showHouseService() {
        
        String dataHouse = FuncWriteAndReadFileCSV.readCsvFile(PATH_FILE_HOUSE);
        String[] houseArray = dataHouse.split("\n");
        System.out.println( "--------------------\n" +
                            "-All House In Resort-" +
                            "\n--------------------");
        for (int i = 0; i < houseArray.length; i++) {
            if (i == 0) {
                continue;
            }
            String[] aHouse = houseArray[i].split(",");
            House house = new House();
            house.setId(aHouse[0]);
            house.setNameService(aHouse[1]);
            house.setAreaUse(aHouse[2]);
            house.setRentCost(aHouse[3]);
            house.setMaxGuest(aHouse[4]);
            house.setRentType(aHouse[5]);
            house.setAccompaniedService(aHouse[6]);
            house.setRoomStandard(aHouse[7]);
            house.setConvenient(aHouse[8]);
            house.setFloor(aHouse[9]);
            house.showInfo();
        }

    }
    public void showRoomService() {

        String dataRoom = FuncWriteAndReadFileCSV.readCsvFile(PATH_FILE_ROOM);
        String[] roomArray = dataRoom.split("\n");
        System.out.println( "--------------------\n" +
                            "-All Room In Resort-" +
                            "\n--------------------");
        for (int i = 0; i < roomArray.length; i++) {
            if (i == 0) {
                continue;
            }
            String[] aRoom = roomArray[i].split(",");
            Room room = new Room();
            room.setId(aRoom[0]);
            room.setNameService(aRoom[1]);
            room.setAreaUse(aRoom[2]);
            room.setRentCost(aRoom[3]);
            room.setMaxGuest(aRoom[4]);
            room.setRentType(aRoom[5]);
            room.setAccompaniedService(aRoom[6]);
            room.setFreeService(aRoom[7]);
            room.showInfo();
        }

    }
    public void showAllNameVillaNotDuplicate() {
        TreeSet<String> treeSetNameVilla = FuncWriteAndReadFileCSV.getNameServiceFromFileCSV(PATH_FILE_VILLA);
        System.out.println("- Name Of All Villa In Resort -");
        for (String name : treeSetNameVilla) {
            System.out.println(name);
        }
        System.out.println("Show All Name Of Villa Successfully ! Enter to continue");
        input.nextLine();
        displayMainMenu();
    }
    public void showAllNameHouseNotDuplicate() {
        TreeSet<String> treeSetNameHouse = FuncWriteAndReadFileCSV.getNameServiceFromFileCSV(PATH_FILE_HOUSE);
        System.out.println("- Name Of All House In Resort -");
        for (String name : treeSetNameHouse) {
            System.out.println(name);
        }
        System.out.println("Show All Name Of House Successfully ! Enter to continue");
        input.nextLine();
        displayMainMenu();
    }
    public void showAllNameRoomNotDuplicate() {
        TreeSet<String> treeSetNameRoom = FuncWriteAndReadFileCSV.getNameServiceFromFileCSV(PATH_FILE_ROOM);
        System.out.println("- Name Of All Room In Resort -");
        for (String name : treeSetNameRoom) {
            System.out.println(name);
        }
        System.out.println("Show All Name Of Room Successfully ! Enter to continue");
        input.nextLine();
        displayMainMenu();
    }
//  ----------------------------------------------------------------------------------------
    public void addNewCustomer() {
        System.out.println("Enter amount of customer you want to add : ");
        int number = Integer.parseInt(input.nextLine());
        Customer customer;
        for (int i = 0; i < number;i++) {
            customer = customerService.addNewCustomer();
            String oldFile = FuncWriteAndReadFileCSV.readCsvFile(PATH_FILE_CUSTOMER);
            FuncWriteAndReadFileCSV.writeCsvFile(oldFile,customer);
            System.out.println("Add New Customer SuccessFully");
        }

    }
//  ----------------------------------------------------------------------------------------
    public void showInfoCustomer () {
        List<Customer> customerList = new ArrayList<>();
        String dataCustomer = FuncWriteAndReadFileCSV.readCsvFile(PATH_FILE_CUSTOMER);
        String[] customerArray = dataCustomer.split("\n");
        for (int i = 0; i < customerArray.length; i++) {
            if (i == 0) {
                continue;
            }
            String[] aCustomer = customerArray[i].split(",");
            Customer customer = new Customer();
            customer.setId(aCustomer[0]);
            customer.setNameCustomer(aCustomer[1]);
            customer.setBirthdayCustomer(aCustomer[2]);
            customer.setGenderCustomer(aCustomer[3]);
            customer.setIdCardCustomer(aCustomer[4]);
            customer.setPhoneNumberCustomer(aCustomer[5]);
            customer.setEmailCustomer(aCustomer[6]);
            customer.setTypeCustomer(aCustomer[7]);
            customer.setAddressCustomer(aCustomer[8]);
            customerList.add(customer);
        }
        Collections.sort(customerList, new NameCustomerComparator());
        System.out.println( "---------------\n" +
                            "-Customer List-" +
                            "\n---------------");
        for (int i = 0 ; i < customerList.size(); i++) {
            System.out.println( "No." + (i + 1) );
            customerList.get(i).showInfo();
        }

    }
//  ----------------------------------------------------------------------------------------
    public void addNewBooking () {
        // Display List Customer
        List<Customer> customerList = new ArrayList<>();
        String dataCustomer = FuncWriteAndReadFileCSV.readCsvFile(PATH_FILE_CUSTOMER);
        String[] customerArray = dataCustomer.split("\n");
        for (int i = 0; i < customerArray.length; i++) {
            if (i == 0) {
                continue;
            }
            String[] aCustomer = customerArray[i].split(",");
            Customer customer = new Customer();
            customer.setId(aCustomer[0]);
            customer.setNameCustomer(aCustomer[1]);
            customer.setBirthdayCustomer(aCustomer[2]);
            customer.setGenderCustomer(aCustomer[3]);
            customer.setIdCardCustomer(aCustomer[4]);
            customer.setPhoneNumberCustomer(aCustomer[5]);
            customer.setEmailCustomer(aCustomer[6]);
            customer.setTypeCustomer(aCustomer[7]);
            customer.setAddressCustomer(aCustomer[8]);
            customerList.add(customer);
        }

        Collections.sort(customerList, new NameCustomerComparator());
        System.out.println( "---------------\n" +
                            "-Customer List-" +
                            "\n---------------");
        for (int i = 0 ; i < customerList.size(); i++) {
            System.out.println( "No." + (i + 1) );
            customerList.get(i).showInfo();
        }
        // Choose Customer Booking
        System.out.println("Enter Your Choice - Number Of Customer : ");
        int customerChoice = Integer.parseInt(input.nextLine());
        while (customerChoice < 1 || customerChoice > customerList.size()) {
            System.out.println("Your Choice Is Out Of ListCustomer'size : " + customerList.size() + ". Please Try Again!" );
            System.out.println("Enter Your Customer Choice Again : ");
            customerChoice = Integer.parseInt(input.nextLine());
        }
        Customer customerBooking = customerList.get(customerChoice - 1);
        //Choose Service Booking
        System.out.println( "1. Booking Villa\n" +
                            "2. Booking House \n" +
                            "3. Booking Room");
        System.out.println("Enter Your Choice - Number Of Booking Service : ");
        int serviceChoice = Integer.parseInt(input.nextLine());
        while (serviceChoice < 1 || serviceChoice > 3) {
            System.out.println("Your choice is out of Booking Menu . Please try again!" );
            System.out.println("Enter your booking choice again : ");
            serviceChoice = Integer.parseInt(input.nextLine());
        }

        switch (serviceChoice) {
            case 1:

                List<Villa> villaList = new ArrayList<>();
                String dataVilla = FuncWriteAndReadFileCSV.readCsvFile(PATH_FILE_VILLA);
                String[] villaArray = dataVilla.split("\n");
                for (int i = 0; i < villaArray.length; i++) {
                    if (i == 0) {
                        continue;
                    }
                    String[] aVilla = villaArray[i].split(",");
                    Villa villa = new Villa();
                    villa.setId(aVilla[0]);
                    villa.setNameService(aVilla[1]);
                    villa.setAreaUse(aVilla[2]);
                    villa.setRentCost(aVilla[3]);
                    villa.setMaxGuest(aVilla[4]);
                    villa.setRentType(aVilla[5]);
                    villa.setAccompaniedService(aVilla[6]);
                    villa.setRoomStandard(aVilla[7]);
                    villa.setConvenient(aVilla[8]);
                    villa.setAreaPool(aVilla[9]);
                    villa.setFloor(aVilla[10]);
                    villaList.add(villa);
                }
                System.out.println( "--------------------\n" +
                                    "-All Villa In Resort-" +
                                    "\n--------------------");
                for (int i = 0; i < villaList.size(); i++) {
                    System.out.println("No." + (i + 1));
                    villaList.get(i).showInfo();
                }
                System.out.println("Enter Your Choice - Number Of Villa : ");
                int villaChoice = Integer.parseInt(input.nextLine());
                while (villaChoice < 1 || villaChoice > villaList.size()) {
                    System.out.println("Your Choice Is Out Of ListVilla'size : " + villaList.size() + ". Please Try Again!");
                    System.out.println("Enter Your Villa Choice Again : ");
                    villaChoice = Integer.parseInt(input.nextLine());
                }
                Villa villa = villaList.get(villaChoice - 1);
                customerBooking.setServiceCustomer(villa);
                break;
            case 2:

                List<House> houseList = new ArrayList<>();
                String dataHouse = FuncWriteAndReadFileCSV.readCsvFile(PATH_FILE_HOUSE);
                String[] houseArray = dataHouse.split("\n");
                for (int i = 0; i < houseArray.length; i++) {
                    if (i == 0) {
                        continue;
                    }
                    String[] aHouse = houseArray[i].split(",");
                    House house = new House();
                    house.setId(aHouse[0]);
                    house.setNameService(aHouse[1]);
                    house.setAreaUse(aHouse[2]);
                    house.setRentCost(aHouse[3]);
                    house.setMaxGuest(aHouse[4]);
                    house.setRentType(aHouse[5]);
                    house.setAccompaniedService(aHouse[6]);
                    house.setRoomStandard(aHouse[7]);
                    house.setConvenient(aHouse[8]);
                    house.setFloor(aHouse[9]);
                    houseList.add(house);
                }
                System.out.println( "--------------------\n" +
                                    "-All House In Resort-" +
                                    "\n--------------------");
                for (int i = 0; i < houseList.size(); i++) {
                    System.out.println("No." + (i + 1));
                    houseList.get(i).showInfo();
                }
                System.out.println("Enter Your Choice - Number Of House : ");
                int houseChoice = Integer.parseInt(input.nextLine());
                while (houseChoice < 1 || houseChoice > houseList.size()) {
                    System.out.println("Your Choice Is Out Of ListHouse'size : " + houseList.size() + ". Please Try Again!");
                    System.out.println("Enter Your House Choice Again : ");
                    houseChoice = Integer.parseInt(input.nextLine());
                }
                House house = houseList.get(houseChoice - 1);
                customerBooking.setServiceCustomer(house);
                break;
            case 3:

                List<Room> roomList = new ArrayList<>();
                String dataRoom = FuncWriteAndReadFileCSV.readCsvFile(PATH_FILE_ROOM);
                String[] roomArray = dataRoom.split("\n");
                for (int i = 0; i < roomArray.length; i++) {
                    if (i == 0) {
                        continue;
                    }
                    String[] aRoom = roomArray[i].split(",");
                    Room room = new Room();
                    room.setId(aRoom[0]);
                    room.setNameService(aRoom[1]);
                    room.setAreaUse(aRoom[2]);
                    room.setRentCost(aRoom[3]);
                    room.setMaxGuest(aRoom[4]);
                    room.setRentType(aRoom[5]);
                    room.setAccompaniedService(aRoom[6]);
                    room.setFreeService(aRoom[7]);
                    roomList.add(room);
                }
                System.out.println( "--------------------\n" +
                                    "-All Room In Resort-" +
                                    "\n--------------------");
                for (int i = 0; i < roomList.size(); i++) {
                    System.out.println("No." + (i + 1));
                    roomList.get(i).showInfo();
                }
                System.out.println("Enter Your Choice - Number Of Room : ");
                int roomChoice = Integer.parseInt(input.nextLine());
                while (roomChoice < 1 || roomChoice > roomList.size()) {
                    System.out.println("Your Choice Is Out Of ListRoom'size : " + roomList.size() + ". Please Try Again!");
                    System.out.println("Enter Your Room Choice Again : ");
                    roomChoice = Integer.parseInt(input.nextLine());
                }
                Room room = roomList.get(roomChoice - 1);
                customerBooking.setServiceCustomer(room);
                break;
        }
        Booking newBooking = new Booking(customerBooking);
        String oldFile = FuncWriteAndReadFileCSV.readCsvFile(PATH_FILE_BOOKING);
        FuncWriteAndReadFileCSV.writeCsvFile(oldFile,newBooking);
        System.out.println("Add New Booking SuccessFully");
    }
//  ----------------------------------------------------------------------------------------
    public void showInfoEmployee () {
        Map<String,Employee> employeeMap = new HashMap<>();
        String dataEmployee = FuncWriteAndReadFileCSV.readCsvFile(PATH_FILE_EMPLOYEE);
        String[] employeeArray = dataEmployee.split("\n");
        for (int i = 0; i < employeeArray.length; i++) {
            if (i == 0) {
                continue;
            }
            String[] aEmployee = employeeArray[i].split(",");
            Employee employee = new Employee();
            employee.setId(aEmployee[0]);
            employee.setNameEmployee(aEmployee[1]);
            employee.setBirthdayEmployee(aEmployee[2]);
            employee.setAddressEmployee(aEmployee[3]);
            employeeMap.put(employee.getId(),employee);
        }
        System.out.println( "--------------------\n" +
                            "-All Employee In Resort-" +
                            "\n--------------------");
        for (Map.Entry<String,Employee> entry : employeeMap.entrySet()) {
            entry.getValue().showInfo();
        }
    }
//  ----------------------------------------------------------------------------------------
    public void addNewBookingCinema() {
        System.out.println("Enter number of ticket : ");
        int numberTicket = 0;
        while (numberTicket < 1) {
            System.out.println("Number of ticket must be higher than 0");
            numberTicket = Integer.parseInt(input.nextLine());
        }

        List<Customer> customerList = new ArrayList<>();
        String dataCustomer = FuncWriteAndReadFileCSV.readCsvFile(PATH_FILE_CUSTOMER);
        String[] customerArray = dataCustomer.split("\n");
        for (int i = 0; i < customerArray.length; i++) {
            if (i == 0) {
                continue;
            }
            String[] aCustomer = customerArray[i].split(",");
            Customer customer = new Customer();
            customer.setId(aCustomer[0]);
            customer.setNameCustomer(aCustomer[1]);
            customer.setBirthdayCustomer(aCustomer[2]);
            customer.setGenderCustomer(aCustomer[3]);
            customer.setIdCardCustomer(aCustomer[4]);
            customer.setPhoneNumberCustomer(aCustomer[5]);
            customer.setEmailCustomer(aCustomer[6]);
            customer.setTypeCustomer(aCustomer[7]);
            customer.setAddressCustomer(aCustomer[8]);
            customerList.add(customer);
        }

        for (int i = 0; i < numberTicket; i++) {

            Collections.sort(customerList, new NameCustomerComparator());
            System.out.println( "---------------\n" +
                                "-Customer List-" +
                                "\n---------------");
            for (int j = 0 ; j < customerList.size(); j++) {
                System.out.println( "No." + (j + 1) );
                customerList.get(j).showInfo();
            }
            // Choose Customer Booking Cinema
            System.out.println("Enter Your Choice - Number Of Customer Want To Booking Cinema4D : ");
            int customerChoice = Integer.parseInt(input.nextLine());
            while (customerChoice < 1 || customerChoice > customerList.size()) {
                System.out.println("Your Choice Is Out Of ListCustomer'size : " + customerList.size() + ". Please Try Again!" );
                System.out.println("Enter Your Customer Choice Again : ");
                customerChoice = Integer.parseInt(input.nextLine());
            }
            Customer customerBookingCinema = customerList.get(customerChoice - 1);
            bookingCinema4DService.addBookingCinema(customerBookingCinema);
            System.out.println("Add New Booking Cinema4D - Ticket " + (i+1) +" Successfully, Enter to continue");
            input.nextLine();
        }
    }
//  ----------------------------------------------------------------------------------------
    private void showBookingCinema() {
        Queue<Customer> bookingCinemaList = bookingCinema4DService.getAllBookingCinema();
        System.out.println( "-------------------------\n" +
                            "- All Booking Cinema 4D -" +
                            "\n-------------------------");
        while (true) {
            Customer customer = bookingCinemaList.poll();
            if (customer == null) {
                break;
            }
            customer.showInfo();
        }
    }
//  ----------------------------------------------------------------------------------------
    private void searchFilingCabinetsOfEmployee() {
        System.out.println("Enter Id Of Employee: ");
        String idEmployee = input.nextLine();
        Employee employee = filingCabinetsService.findEmployeeById(idEmployee);
        if (employee == null) {
            System.out.println("Not found Filing Cabinets!");
        } else {
            employee.showInfo();
        }
    }

//  ----------------------------------------------------------------------------------------
    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.displayMainMenu();
    }


}
