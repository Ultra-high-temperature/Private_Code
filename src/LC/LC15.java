package LC;

public class LC15 {
    public int singleNumber(int[] A) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            result^=A[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = {1, 1, 2, 2, 3, 3, 4};
        LC15 lc15 = new LC15();
        int i = lc15.singleNumber(ints);
        System.out.println(i);
    }
}
