package PrimaryBook;

public class LB12 {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char t = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = t;
        }
    }

    public static void main(String[] args) {
        char[] chars = {'1', '2', '3', '4','5'};
        LB12 lb12 = new LB12();
        lb12.reverseString(chars);
        System.out.printf("");
    }
}
