package CI;

public class JZ12 {
    public double Power(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        int abs = exponent;
        if (exponent < 0) {
            abs = Math.abs(exponent);
        }
        double result = 1f;
        for (int i = 0; i < abs; i++) {
            result = result * base;
        }
        if (exponent < 0)
            result = 1 / result;
        return result;
    }

    public static void main(String[] args) {
        JZ12 jz12 = new JZ12();
        double power = jz12.Power(2, -3);
        System.out.println(power);
    }
}
