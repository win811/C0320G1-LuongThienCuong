package Array.thuchanh;

public class FindMinValueInArray {

    static int getMinValue (int[] array) {
        int min = array[0];
        for (int i = 1 ; i < array.length ; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        System.out.println("Smallest value in array is : " + getMinValue(array));
    }
}
