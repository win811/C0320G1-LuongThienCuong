package commons;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.MappingStrategy;
import com.opencsv.exceptions.CsvException;
import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;
import models.*;

import java.io.*;
import java.lang.reflect.ParameterizedType;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class FuncWriteAndReadFileCSV {
    private static final char COMMA_DELIMITER = ',';
    private static final char DEFAULT_QUOTE = '"';
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final int NUM_OF_LINE_SKIP = 1;
    private static final String PATH_FILE_VILLA = "src/data/Villa.csv";
    private static final String PATH_FILE_HOUSE = "src/data/House.csv";
    private static final String PATH_FILE_ROOM = "src/data/Room.csv";
    private static final String PATH_FILE_BOOKING = "src/data/Booking.csv";
    private static final String PATH_FILE_CUSTOMER = "src/data/Customer.csv";
    private static final String PATH_FILE_EMPLOYEE = "src/data/Employee.csv";
    private static final String FILE_SERVICES_HEADER_DEFAULT = "Id,Name Service, Area Use, Rent Cost, Max Number Of People,Type Rent,Accompanied Service";
    private static final String FILE_HEADER_OF_VILLA = FILE_SERVICES_HEADER_DEFAULT +
            ",Room Standard,Convenient Description,AreaPool,Number Of Floors";
    private static final String FILE_HEADER_OF_HOUSE = FILE_SERVICES_HEADER_DEFAULT +
            ",Room Standard,Convenient Description,Number Of Floors";
    private static final String FILE_HEADER_OF_ROOM = FILE_SERVICES_HEADER_DEFAULT + ",Free Service";
    private static final String FILE_HEADER_OF_CUSTOMER = "Id,Name Of Customer,Birthday,Gender,Id Card,Phone Number," +
            "Email,Type Customer,Address";
    private static final String FILE_HEADER_OF_BOOKING = FILE_HEADER_OF_CUSTOMER + "," + FILE_SERVICES_HEADER_DEFAULT;
    private static final String FILE_HEADER_OF_EMPLOYEE = "Id,Name Of Employee,Birthday,Address";

    //    @SuppressWarnings("unchecked")
    public static String readCsvFile(String pathFile) {
        Path pathNow;
        String head;
        switch (pathFile) {
            case PATH_FILE_VILLA:
                pathNow = Paths.get(PATH_FILE_VILLA);
                head = FILE_HEADER_OF_VILLA;
                break;
            case PATH_FILE_HOUSE:
                pathNow = Paths.get(PATH_FILE_HOUSE);
                head = FILE_HEADER_OF_HOUSE;
                break;
            case PATH_FILE_ROOM:
                pathNow = Paths.get(PATH_FILE_ROOM);
                head = FILE_HEADER_OF_ROOM;
                break;
            case PATH_FILE_CUSTOMER:
                pathNow = Paths.get(PATH_FILE_CUSTOMER);
                head = FILE_HEADER_OF_CUSTOMER;
                break;
            case PATH_FILE_BOOKING:
                pathNow = Paths.get(PATH_FILE_BOOKING);
                head = FILE_HEADER_OF_BOOKING;
                break;
            default :
                pathNow = Paths.get(PATH_FILE_EMPLOYEE);
                head = FILE_HEADER_OF_EMPLOYEE;
        }
        FileWriter fileWriter = null;
        if (!Files.exists(pathNow)) {
            try {
                fileWriter = new FileWriter(pathNow.toString());
                fileWriter.append(head);
                fileWriter.append(NEW_LINE_SEPARATOR);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("Error while flushing/closing fileWriter !!!");
                    e.printStackTrace();
                }
            }
        }

        String line;
        String resultString = "";
        BufferedReader buffer = null;
        try {
            FileReader reader = new FileReader(pathNow.toString());
            buffer = new BufferedReader(reader);
            while ((line = buffer.readLine()) != null) {
                resultString += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                buffer.close();
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return resultString;
    }

    public static void writeCsvFile (String oldFile,Object service){
        String pathNow;
        if (service instanceof Villa) {
            pathNow = PATH_FILE_VILLA;
        } else if (service instanceof House) {
            pathNow = PATH_FILE_HOUSE;
        } else if (service instanceof Room){
            pathNow = PATH_FILE_ROOM;
        } else if (service instanceof Customer) {
            pathNow = PATH_FILE_CUSTOMER;
        } else if (service instanceof Booking){
            pathNow = PATH_FILE_BOOKING;
        } else {
            pathNow = PATH_FILE_EMPLOYEE;
        }
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(pathNow);
            fileWriter.append(oldFile);
            fileWriter.append(service.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }

    public static TreeSet<String> getNameServiceFromFileCSV(String pathFile) {
        String line = "";
        TreeSet<String> treeSetNameService = new TreeSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] arrService = line.split(",");
                treeSetNameService.add(arrService[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return treeSetNameService;
    }

}

