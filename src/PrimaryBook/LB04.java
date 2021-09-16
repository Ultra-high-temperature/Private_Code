package PrimaryBook;

import java.util.HashSet;

public class LB04 {
    //基础hashset
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> ints = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(ints.contains(nums[i])){
                return true;
            }else {
                ints.add(nums[i]);
            }
        }
        return false;
    }

    //
}
