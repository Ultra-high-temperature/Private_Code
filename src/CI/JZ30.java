package CI;

public class JZ30 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum+=array[i];
            if(max<sum){
                max = sum;
            }
            if(sum<0){
                sum = 0;
            }
        }
        return max;
    }

    public static void main0(String[] args) {
        int[] arr = {-1,2,-14,3,-1,5};
        JZ30 jz30 = new JZ30();
        int i = jz30.FindGreatestSumOfSubArray(arr);
        System.out.printf("");
    }

    public static void main(String[] args) {

    }
}
