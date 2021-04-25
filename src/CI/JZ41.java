package CI;

import java.util.ArrayList;

public class JZ41 {
    //愚蠢的穷举法
    public ArrayList<ArrayList<Integer>> FindContinuousSequence1(int sum) {
        int total = 0;
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= sum / 2; i++) {
            int ptr = i;
            while (total < sum) {
                total += ptr;
                integers.add(ptr);
                ptr++;
            }
            if (total == sum) {
                result.add(integers);
                integers = new ArrayList<>();
            } else {
                integers.clear();
            }
            total = 0;
        }
        return result;
    }

    //滑动窗口法
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if(sum<2){
            return new ArrayList<>();
        }
        int start = 1;
        int end = 2;
        int now = 1;
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        //外层挪动end指针
        while (start<=sum/2+1){
            if(now==sum){
                build(lists,start,end);
            }
            now+=end;
            end++;
            //当now>sum时，挪动start指针直到小于等于sum
            while (now>sum){
                now-=start;
                start++;
            }
        }
        return lists;
    }

    void build(ArrayList<ArrayList<Integer>> lists,int start,int end){
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = start; i < end; i++) {
            integers.add(i);
        }
        lists.add(integers);
    }

    public static void main(String[] args) {
        JZ41 jz41 = new JZ41();
        ArrayList<ArrayList<Integer>> arrayLists = jz41.FindContinuousSequence(9);
        System.out.printf("");
    }
}
