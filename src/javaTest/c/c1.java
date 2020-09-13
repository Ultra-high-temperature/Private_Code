package javaTest.c;

public class c1 {

    public int[] twoSum (int[] numbers, int target) {
        int length=numbers.length;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if (target==numbers[i]+numbers[j]){
                    int re[]={i+1,j+1};
                    return re;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int numbers[]={3,2,4};
        int target=6;
        c1 c1 = new c1();
        int[] ints = c1.twoSum(numbers, target);
        System.out.println(ints);
    }
}
