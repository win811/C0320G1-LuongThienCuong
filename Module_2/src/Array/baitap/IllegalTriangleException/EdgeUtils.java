package Array.baitap.IllegalTriangleException;

public class EdgeUtils {
    public static void checkEdge(int[] triangle) throws IllegalTriangleException {
        if (triangle[0] < 0 || triangle[1] < 0 || triangle[2] < 0 || triangle[0] + triangle[1] <= triangle[2] ) {
            throw new IllegalTriangleException("Value is not correct!");
        }
        System.out.println("Value is correct!");
    }
}
