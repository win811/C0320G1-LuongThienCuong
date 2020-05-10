package Array.baitap;

public class TimeCharInStr {
    public static void main(String[] args) {
        String str = "Hello";
        char character = 'l';
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == character) {
                count++;
            }
        }
        System.out.println("Character \"" + character + "\" appear " + count + " times in \"" + str + "\"");
    }
}
