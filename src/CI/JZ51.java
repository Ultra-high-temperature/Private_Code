package CI;

public class JZ51 {
    public int[] multiply(int[] A) {
        int[] b = new int[A.length];
        b[0] = 1;
        for (int i = 1; i <b.length; i++) {
            b[i] = b[i-1]*A[i-1];
        }
        int temp = 1;
        for (int i = b.length-2; i >=0; i--) {
            temp *= A[i+1];
            b[i] *= temp;
        }
        return b;
    }

    public static void main(String[] args) {
        JZ51 jz51 = new JZ51();
        int[] arr = {1,2,3,4,5};
        int[] multiply = jz51.multiply(arr);
        System.out.println();
    }
}
