package CI;

import javafx.print.Collation;

import java.util.*;

public class JZ64 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num.length < size||size ==0) {
            return result;
        }
        LinkedList<Integer> list = new LinkedList<>();
        //初始化
        for (int i = 0; i < size; i++) {
            while (list.size()!=0&&list.peekLast()<num[i]){
                list.pollLast();
            }
            list.add(num[i]);
        }
        result.add(list.getFirst());

        //先滑动 后计算最大值
        for (int i = size; i < num.length; i++) {

            int input = num[i];
            int output = num[i - size];
            if(output == list.getFirst()){
                list.pollFirst();
            }
            while (list.size()!=0&&list.peekLast()<input){
                list.pollLast();
            }
            list.add(input);

            result.add(list.getFirst());
        }
        return result;
    }

    public static void main(String[] args) {
        JZ64 jz64 = new JZ64();
//        int[] arr = {2,3,4,2,6,2,5,1};
        int[] arr = {};
        ArrayList<Integer> list = jz64.maxInWindows(arr, 3);
        System.out.println();
    }


}
