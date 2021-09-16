package PrimaryBook;

public class LB08 {
    public void moveZeroes(int[] nums) {
        int searchIndex = 1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                while (searchIndex< nums.length&&nums[searchIndex]==0){
                    searchIndex++;
                }
                if(searchIndex == nums.length) break;
                nums[i] = nums[searchIndex];
                nums[searchIndex]=0;
            }
            searchIndex++;
        }
    }


    public static void main(String[] args) {
        int[] ints = {0, 1, 2, 30, 0, 3, 5};
        LB08 lb08 = new LB08();
        lb08.moveZeroes(ints);
        System.out.printf("");
    }
}
