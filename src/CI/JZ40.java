package CI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//一个整型数组里除了两个数字只出现一次，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
public class JZ40 {
    //hash法
    public int[] FindNumsAppearOnce1(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Integer i1 = null, i2 = null;
        int[] ints = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], 2);
            } else {
                map.put(array[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry :
                map.entrySet()) {
            if (entry.getValue() == 1) {
                if (i1 == null) {
                    i1 = entry.getKey();
                } else {
                    i2 = entry.getKey();
                }
            }
        }
        ints[0] = i1 < i2 ? i1 : i2;
        ints[1] = i1 > i2 ? i1 : i2;
        return ints;
    }
    //排序法
    public int[] FindNumsAppearOnce(int[] array){
        fastSort(array,0,array.length-1);
        int now = array[0];
        int t = 1;
        Integer i1 = null, i2 = null;
        for (int i = 1; i < array.length; i++) {
            if(now != array[i]||t==2){
                //找到目标,前一个数是目标
                if(t == 1){
                    if (i1 == null) {
                        i1 = now;
                    } else {
                        i2 = now;
                    }
                    now = array[i];
                }else if(t==2){
                    //不是目标
                    now = array[i];
                    t=1;
                }
            }else t++;
        }
        if(i2 == null){
            i2 = array[array.length-1];
        }
        int[] ints = new int[2];
        ints[0] = i1 < i2 ? i1 : i2;
        ints[1] = i1 > i2 ? i1 : i2;
        return ints;
    }
    private void fastSort(int[] array,int start,int end){
        if(start>=end){
            return;
        }
        int i = start;
        int l = start;
        int r = end;
        while (l<r){
            //找到第一个比他小的
            while (l<r&&array[i]<=array[r]){
                r--;
            }
            //找第一个比他大的
            while (l<r&&array[i]>=array[l]){
                l++;
            }
            swap(array,l,r);
        }
        swap(array,i,l);
        fastSort(array, start, l-1);
        fastSort(array, l+1, end);
    }
    private void swap(int[] array,int start,int end){
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4,6,1,1,1,1};
        JZ40 jz40 = new JZ40();
        int[] ints = jz40.FindNumsAppearOnce(arr);
        System.out.printf("");
    }
}
