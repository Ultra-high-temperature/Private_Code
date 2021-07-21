package CI;

import java.util.ArrayList;

public class JZ42 {
    //输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
    // 如果有多对数字的和等于S，输出两个数的乘积最小的。
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        //外层从0到n遍历起始点
        //内层从n到0找重终点 内外和小于s时终止内层查找
        for (int i = 0; i < array.length-1; i++) {
            for (int j = array.length-1; j > i ; j--) {
                //两数和相同，两数相差越大，乘积越小
                //所以找第一个
                if(array[i]+array[j]==sum){
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(array[i]);
                    integers.add(array[j]);
                    return integers;
                }
                if(array[i]+array[j]<sum){
                    break;
                }
            }
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        JZ42 jz42 = new JZ42();
        int[] arr = {1,2,4,7,11,15};
        ArrayList<Integer> integers = jz42.FindNumbersWithSum(arr, 15);
        System.out.printf("");
    }
}
