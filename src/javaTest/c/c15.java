package javaTest.c;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class c15 {
    //有序区起始范围,这里用的是冒泡
    static int a = 0;

    public String solve(int[] nums) {
        a = nums.length - 1;
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                compare(j, j + 1, nums);
            }
        }
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            s.append(nums[i]);
        }
        return s.toString();
    }

    void compare(int a, int b, int[] nums) {
        String sa = String.valueOf(nums[a]);
        String sb = String.valueOf(nums[b]);
        if (sa.length() != sb.length()) {
            String max = max(nums);
            if (sa.length() > sb.length()) {
                sb = sb + max;
            }else {
                sa = sa + max;
            }
        }
        int l = sa.length() > sb.length() ? sb.length() : sa.length();
        for (int i = 0; i < l; i++) {
            if (sa.charAt(i) < sb.charAt(i)) {
                nums[a] += nums[b];
                nums[b] = nums[a] - nums[b];
                nums[a] = nums[a] - nums[b];
                break;
            }
            if (sa.charAt(i) > sb.charAt(i)) {
                break;
            }
//            if(i==i-1){
//
//            }
        }
    }

    String max(int[] nums) {
        String maxValue = "0";
        int max = 0;
        for (int i = 0; i < a; i++) {
            String s = String.valueOf(nums[i]);
            if (s.charAt(0) > maxValue.charAt(0)) {
                max = i;
                maxValue = s;
            }
        }
//        AtomicInteger
        Queue q = new ArrayDeque();
        return maxValue;
    }

    public static void main(String[] args) {
        int[] a = {3, 37, 50, 1};
        c15 c15 = new c15();
        String solve = c15.solve(a);
        System.out.println(solve);
    }

//    public int findtheNumber (int[] arr, int k) {
//        if(k%2==1){
//
//        }
//    }
}
