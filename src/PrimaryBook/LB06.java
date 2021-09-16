package PrimaryBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LB06 {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int s1:nums1) {
            if(map1.containsKey(s1)){
                map1.put(s1,map1.get(s1)+1);
            }else {
                map1.put(s1,1);
            }
        }
        for (int s2:nums2) {
            if(map1.containsKey(s2)){
                list.add(s2);
                if(map1.get(s2)==1){
                    map1.remove(s2);
                }else {
                    map1.put(s2,map1.get(s2)-1);
                }
            }
        }
        int [] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = {4,9,5};
        int[] ints1 = {9,4,9,8,4};
        LB06 lb06 = new LB06();
        int[] intersect = lb06.intersect(ints1, ints);
        System.out.printf("");
    }
}
