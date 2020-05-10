package Array.baitap.IllegalTriangleException;

import Array.SingleArray;

public class TryCatchTriangleException {
    public static void main(String[] args) {
        int[] triangle = new int[3];
        System.out.println("Input 3 edge's value : ");
        SingleArray.inputValue(triangle);
        try {
            EdgeUtils.checkEdge(triangle);
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }
    }
}
