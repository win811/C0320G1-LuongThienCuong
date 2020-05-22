package Controllers;

import Service.HouseServiceImpl;
import Service.RoomServiceImpl;
import Service.ServiceInterface;
import Service.VillaServiceImpl;
import com.sun.javafx.iio.gif.GIFImageLoaderFactory;
import commons.FuncWriteAndReadFileCSV;
import jdk.nashorn.internal.runtime.arrays.IteratorAction;
import models.House;
import models.Room;
import models.Services;
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
        int choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 1 :
                menuAddNewServices();
                break;
            case 2 :
                menuShowServices();
                break;
            case 3 :
                addNewCustomer();
                break;
            case 4 :
                showInfoCustomer();
                break;
            case 5 :
                addNewBooking();
                break;
            case 6 :
                showInfoEmployee();
                break;
            case 7 :
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
        int choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 1: {
                addListVillaService();
                break;
            }
            case 2: {
                addListHouseService();
                break;
            }
            case 3: {
                addListRoomService();
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
        System.out.println("Enter number of villa you want to add : ");
        int number = Integer.parseInt(input.nextLine());
        Services villa;
        for (int i = 0; i < number;i++) {
            villa = ((ServiceInterface)new VillaServiceImpl()).add();
            String oldFile = FuncWriteAndReadFileCSV.readCsvFile("Villa");
            FuncWriteAndReadFileCSV.writeCsvFile(oldFile,villa);
            System.out.println("Add New Villa SuccessFully");
        }
        System.out.println("CSV file was created successfully ! Enter to continue");
        input.nextLine();
        menuAddNewServices();
    }
    public void addListHouseService() {
        System.out.println("Enter number of House you want to add : ");
        int number = Integer.parseInt(input.nextLine());
        Services house;
        for (int i = 0; i < number;i++) {
            house = ((ServiceInterface)new HouseServiceImpl()).add();
            String oldFile = FuncWriteAndReadFileCSV.readCsvFile("House");
            FuncWriteAndReadFileCSV.writeCsvFile(oldFile,house);
            System.out.println("Add New House SuccessFully");
        }
        menuAddNewServices();
        System.out.println("CSV file was created successfully ! Enter to continue");
        input.nextLine();
    }
    public void addListRoomService() {
        System.out.println("Enter number of Room you want to add : ");
        int number = Integer.parseInt(input.nextLine());
        Services room;
        for (int i = 0; i < number;i++) {
            room = ((ServiceInterface)new RoomServiceImpl()).add();
            String oldFile = FuncWriteAndReadFileCSV.readCsvFile("Room");
            FuncWriteAndReadFileCSV.writeCsvFile(oldFile,room);
            System.out.println("Add New Room SuccessFully");
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
        int choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 1: {
                showVillaService();
                break;
            }
            case 2: {
                showHouseService();
                break;
            }
            case 3: {
                showRoomService();
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
                System.exit(0);
            }
        }
    }

    public void showVillaService() {

        String data = FuncWriteAndReadFileCSV.readCsvFile("Villa");
        String[] villaArray = data.split("\n");
        System.out.println( "--------------------\n" +
                            "-All Villa In Resort-" +
                            "\n--------------------");
        for (int i = 0; i < villaArray.length; i++) {
            if (i == 0) {
                continue;
            }
            String[] tempVilla = villaArray[i].split(",");
            Villa villa = new Villa();
            villa.setId(tempVilla[0]);
            villa.setNameService(tempVilla[1]);
            villa.setAreaUse(tempVilla[2]);
            villa.setRentCost(tempVilla[3]);
            villa.setMaxGuest(tempVilla[4]);
            villa.setRentType(tempVilla[5]);
            villa.setAccompaniedService(tempVilla[6]);
            villa.setRoomStandard(tempVilla[7]);
            villa.setConvenient(tempVilla[8]);
            villa.setAreaPool(tempVilla[9]);
            villa.setFloor(tempVilla[10]);
            villa.showInfo();
        }
        System.out.println("Show Villa successfully ! Enter to continue");
        input.nextLine();
        menuShowServices();
    }
    public void showHouseService() {
        
        String data = FuncWriteAndReadFileCSV.readCsvFile("House");
        String[] houseArray = data.split("\n");
        System.out.println( "--------------------\n" +
                            "-All House In Resort-" +
                            "\n--------------------");
        for (int i = 0; i < houseArray.length; i++) {
            if (i == 0) {
                continue;
            }
            String[] tempHouse = houseArray[i].split(",");
            House house = new House();
            house.setId(tempHouse[0]);
            house.setNameService(tempHouse[1]);
            house.setAreaUse(tempHouse[2]);
            house.setRentCost(tempHouse[3]);
            house.setMaxGuest(tempHouse[4]);
            house.setRentType(tempHouse[5]);
            house.setAccompaniedService(tempHouse[6]);
            house.setRoomStandard(tempHouse[7]);
            house.setConvenient(tempHouse[8]);
            house.setFloor(tempHouse[9]);
            house.showInfo();
        }
        System.out.println("Show House successfully ! Enter to continue");
        input.nextLine();
        menuShowServices();
    }
    public void showRoomService() {

        String data = FuncWriteAndReadFileCSV.readCsvFile("Room");
        String[] roomArray = data.split("\n");
        System.out.println( "--------------------\n" +
                            "-All Room In Resort-" +
                            "\n--------------------");
        for (int i = 0; i < roomArray.length; i++) {
            if (i == 0) {
                continue;
            }
            String[] tempRoom = roomArray[i].split(",");
            Room room = new Room();
            room.setId(tempRoom[0]);
            room.setNameService(tempRoom[1]);
            room.setAreaUse(tempRoom[2]);
            room.setRentCost(tempRoom[3]);
            room.setMaxGuest(tempRoom[4]);
            room.setRentType(tempRoom[5]);
            room.setAccompaniedService(tempRoom[6]);
            room.setFreeService(tempRoom[7]);
            room.showInfo();
        }
        System.out.println("Show Room successfully ! Enter to continue");
        input.nextLine();
        menuShowServices();
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
