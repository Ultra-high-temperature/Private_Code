package PrimaryBook;

public class LB03 {
//    超时了
//    public void rotate(int[] nums, int k) {
//        for (int i = 0; i < k; i++) {
//            move(nums);
//        }
//    }
//    void move(int[] nums){
//        int tempEndValue = nums[nums.length-1];
//        for (int i = nums.length-2; i >=0 ; i--) {
//            nums[i+1] = nums[i];
//        }
//        nums[0] = tempEndValue;
//    }
    //从前往后找 有循环问题
    public void rotate0(int[] nums, int k) {
        int nowIndex = 0;
        int nowValue = nums[0];
        int length = nums.length;

        for (int i = 0; i < length; i++) {


            int newIndex = (k+nowIndex)% length;
            int tempValue = nums[newIndex];
            nums[newIndex] = nowValue;

            nowIndex = newIndex;
            nowValue = tempValue;
        }
    }

    public void rotate(int[] nums, int k) {

        int[] result = new int[nums.length];
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            result[(k+i)% length] = nums[i];
        }

        for (int i = 0; i < length; i++) {
            nums[i] = result[i];
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        LB03 lb03 = new LB03();
        lb03.rotate(arr,2);
        System.out.printf("");
    }
}
