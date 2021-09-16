package PrimaryBook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LB09 {
    public int[] twoSum0(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    //这个思路的主要问题在于 分了两个for循环分别执行加入Map和处理containsKey
    //导致需要分 {1,2,3} 6 和 {1,2,3,3} 6 分别进行考虑
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {1,8, 3,  6};
        LB09 lb09 = new LB09();
        int[] ints = lb09.twoSum(nums, 6);
        System.out.printf("");
    }
}
