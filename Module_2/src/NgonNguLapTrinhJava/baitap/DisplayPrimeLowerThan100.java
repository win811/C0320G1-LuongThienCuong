package NgonNguLapTrinhJava.baitap;

public class DisplayPrimeLowerThan100 {

    public static void main(String[] args) {
        boolean check;
        for (int number = 2 ; number <100; number++) {
            check = true;
            for (int i = 2 ;i <= number/2 ; i++) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.println(number);
            }
        }
    }
}
