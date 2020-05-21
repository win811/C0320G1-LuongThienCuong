package Controllers;

import Service.HouseServiceImpl;
import Service.RoomServiceImpl;
import Service.VillaServiceImpl;
import commons.FuncWriteAndReadFileCSV;
import models.House;
import models.Room;
import models.Villa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    private static List<Villa> villas = new ArrayList<>();
    private static List<House> houses = new ArrayList<>();
    private static List<Room> rooms = new ArrayList<>();

    Scanner input = new Scanner(System.in);
    public void displayMainMenu() {
        System.out.println("--------------------------------");
        System.out.println( "1. Add New Services" +
                            "\n2. Show Services" +
                            "\n3. Add New Customer" +
                            "\n4. Show Information of Customer" +
                            "\n5. Add New Booking" +
                            "\n6. Show Information of Employee" +
                            "\n7. Exit");
        System.out.print("Enter number of function you want to use : ");
        String choice = Integer.toString(input.nextInt());
        switch (choice) {
            case "1" :
                menuAddNewServices();
                break;
            case "2" :
                menuShowServices();
                break;
            case "3" :
                addNewCustomer();
                break;
            case "4" :
                showInfoCustomer();
                break;
            case "5" :
                addNewBooking();
                break;
            case "6" :
                showInfoEmployee();
                break;
            case "7" :
                System.exit(0);
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
        String choice = Integer.toString(input.nextInt());
        switch (choice) {
            case "1": {
                addListVillaService();
                break;
            }
            case "2": {
                addListHouseService();
                break;
            }
            case "3": {
                addListRoomService();
                break;
            }

            case "4": {
                displayMainMenu();
                break;
            }
            case "5": {
                System.exit(0);
            }
            default: {
                System.out.print("Wrong choice,please choose again,press Enter to continue");
                input.nextLine();
                menuAddNewServices();
            }
        }
    }

    public void addListVillaService() {
        System.out.println("Enter number of villa you want to add : ");
        int number = input.nextInt();
        Villa villa;
        for (int i = 0; i < number;i++) {
            villa = new VillaServiceImpl().add();
            villas.add(villa);
            String oldFile = FuncWriteAndReadFileCSV.readCsvFile(villa);
            FuncWriteAndReadFileCSV.writeCsvFile(oldFile,villa);
        }
        System.out.println("CSV file was created successfully ! Enter to continue");
        input.nextLine();
        menuAddNewServices();
    }
    public void addListHouseService() {
        System.out.println("Enter number of House you want to add : ");
        int number = input.nextInt();
        House house;
        for (int i = 0; i < number;i++) {
            house = new HouseServiceImpl().add();
            houses.add(house);
            String oldFile = FuncWriteAndReadFileCSV.readCsvFile(house);
            FuncWriteAndReadFileCSV.writeCsvFile(oldFile,house);
        }
        System.out.println("CSV file was created successfully ! Enter to continue");
        input.nextLine();
        menuAddNewServices();
    }
    public void addListRoomService() {
        System.out.println("Enter number of Room you want to add : ");
        int number = input.nextInt();
        Room room;
        for (int i = 0; i < number;i++) {
            room = new RoomServiceImpl().add();
            rooms.add(room);
            String oldFile = FuncWriteAndReadFileCSV.readCsvFile(room);
            FuncWriteAndReadFileCSV.writeCsvFile(oldFile,room);
        }
        System.out.println("CSV file was created successfully ! Enter to continue");
        input.nextLine();
        menuAddNewServices();
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
        String choice = Integer.toString(input.nextInt());
        switch (choice) {
            case "1": {
                showVillaService();
                break;
            }
            case "2": {
                showHouseService();
                break;
            }
            case "3": {
                showRoomService();
                break;
            }
            case "4": {
                showAllNameVillaNotDuplicate();
                break;
            }
            case "5": {
                showAllNameHouseNotDuplicate();
                break;
            }
            case "6": {
                showAllNameRoomNotDuplicate();
                break;
            }
            case "7": {
                displayMainMenu();
                break;
            }
            default: {
                System.exit(0);
            }
        }
    }

    public void showVillaService() {

    }
    public void showHouseService() {

    }
    public void showRoomService() {

    }
    public void showAllNameVillaNotDuplicate() {

    }
    public void showAllNameHouseNotDuplicate() {

    }
    public void showAllNameRoomNotDuplicate() {

    }
//  ----------------------------------------------------------------------------------------
    public void addNewCustomer() {

    }
//  ----------------------------------------------------------------------------------------
    public void showInfoCustomer () {

    }
//  ----------------------------------------------------------------------------------------
    public void addNewBooking () {

    }
//  ----------------------------------------------------------------------------------------
    public void showInfoEmployee () {

    }

    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.displayMainMenu();
    }





}
