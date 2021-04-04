package CI;

public class JZ11 {
    public int NumberOf1(int n) {
        int i = 1;
        int sum = 0;
        while (i != 0) {
            if ((n & i) != 0) {
                sum++;
            }
            i = i << 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        JZ11 jz11 = new JZ11();
        int i = jz11.NumberOf1(-2147483648);
        System.out.println(i);
    }
}
