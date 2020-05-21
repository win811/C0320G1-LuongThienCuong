package commons;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.MappingStrategy;
import com.opencsv.exceptions.CsvException;
import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;
import models.House;
import models.Services;
import models.Villa;

import java.io.*;
import java.lang.reflect.ParameterizedType;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

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
    private static final String FILE_SERVICES_HEADER_DEFAULT = "Id,Name Service, Area Use, Rent Cost, Max Number Of People,Type Rent";
    private static final String FILE_HEADER_OF_VILLA = FILE_SERVICES_HEADER_DEFAULT +
            ",Room Standard,Convenient Description,AreaPool,Number Of Floors";
    private static final String FILE_HEADER_OF_HOUSE = FILE_SERVICES_HEADER_DEFAULT +
            ",Room Standard,Convenient Description,Number Of Floors";
    private static final String FILE_HEADER_OF_ROOM = FILE_SERVICES_HEADER_DEFAULT + ",Free Service";
    private static final String FILE_HEADER_OF_CUSTOMER = "Id,Name Of Customer,Id Card,Birthday,Gender,Phone Number," +
            "Email,Type Customer,Address";
    private static final String FILE_HEADER_OF_BOOKING = "Id,Name Of Customer,Id Card,Birthday,Gender,Phone Number," +
            "Email,Type Customer,Address,Id Service,Name Service,Area Use," +
            "Rent Cost,Max Number Of People,Type Rent";

    //    @SuppressWarnings("unchecked")
    public static String readCsvFile(Object service) {
        Path path;
        String head;
        if (service instanceof Villa) {
            path = Paths.get(PATH_FILE_VILLA);
            head = FILE_HEADER_OF_VILLA;
        } else if (service instanceof House) {
            path = Paths.get(PATH_FILE_HOUSE);
            head = FILE_HEADER_OF_HOUSE;
        } else {
            path = Paths.get(PATH_FILE_ROOM);
            head = FILE_HEADER_OF_ROOM;
        }
        FileWriter fileWriter = null;
        if (!Files.exists(path)) {
            try {
                fileWriter = new FileWriter(String.valueOf(path));
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
            FileReader reader = new FileReader(String.valueOf(path));
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
        String path;
        String head;
        if (service instanceof Villa) {
            path = PATH_FILE_VILLA;
            head = FILE_HEADER_OF_VILLA;
        } else if (service instanceof House) {
            path = PATH_FILE_HOUSE;
            head = FILE_HEADER_OF_HOUSE;
        } else {
            path = PATH_FILE_ROOM;
            head = FILE_HEADER_OF_ROOM;
        }
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
            fileWriter.append(oldFile);
//            fileWriter.append(NEW_LINE_SEPARATOR);
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

}

