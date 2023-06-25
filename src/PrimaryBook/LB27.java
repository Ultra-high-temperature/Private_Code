package PrimaryBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//
//给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
//
//作者：力扣 (LeetCode)
//链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnq4km/
//来源：力扣（LeetCode）
public class LB27 {
    //二维dp 记录这家的抢劫情况
    public int rob(int[] nums) {
        int[][] dp = new int[2][nums.length];
        //dp0 不抢、dp1 抢
        dp[0][0] = 0;
        dp[1][0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //这屋不抢 max 前屋抢,前屋不抢
            dp[0][i]=Math.max(dp[1][i-1],dp[0][i-1]);
            //这屋抢 前屋不抢+这屋钱
            dp[1][i]= dp[0][i-1]+nums[i];
        }
        return Math.max(dp[1][nums.length-1],dp[0][nums.length-1]);
    }
}
class Solution {

    private final int[] base;
    private final int[] tags;

    public Solution(int[] nums) {
        base = nums;
        tags = new int[nums.length];
    }

    public int[] reset() {
        return base;
    }

    public int[] shuffle() {
        List<Integer> list = Arrays.stream(base).boxed().collect(Collectors.toList());
        int size = list.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            int index = (int) (Math.random() * (size - i - 1));
            Integer integer = list.get(index);
            result[i] = integer;
            list.remove(index);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2, 3});
        int[] shuffle = solution.shuffle();
        int[] reset = solution.reset();
        System.out.printf("");
    }
}