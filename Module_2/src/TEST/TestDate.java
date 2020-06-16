package TEST;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class TestDate implements Serializable {
    public static void main(String[] args) {
//        String birthday = "08/11/1996";
//        Date birthdayDate = new Date(birthday);
//        Date today = new Date();
//        double age = (double) (today.getTime() - birthdayDate.getTime()) / 1000 / 60 / 60 / 24 / 30 / 12;
//        System.out.println(age);
//        //-----------------------------------
//        LocalDate birthDay = LocalDate.of(1996, 11, 8); //specify year, month, date directly
//        LocalDate now = LocalDate.now(); //gets localDate
//        Period diff = Period.between(birthDay,now); //difference between the dates is calculated
//        System.out.println((diff.getYears()));
//        if (diff.getYears() < 18) {
//            System.out.println("Customer mus be older than 18.");
//        }
        ///////////////////////////////
        String a = new String("a");
        String b = new String("a");
        String c = "    ";
        String d = "";
        System.out.println(d.equals(""));
//        System.out.println(a.equals(b));
//        if (a.equals(null) == false) {
//            System.out.println("Khác");
//        }
        System.out.println(c.trim());

    }
}

class A {
    private int x;

    A() {
    }

    A(int value) {
       this.x = value;
    }

}
class B extends A {
   private int y;

   B(int value1, int value2) {
       super(value1);
       this.y = value2;
   }

}