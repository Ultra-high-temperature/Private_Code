package CI;

import java.util.HashMap;

public class JZ28 {
    public int MoreThanHalfNum_Solution1(int [] array) {
        if(array.length ==1){
            return array[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        double mid = (double)array.length/2f;
        for (int i = 0; i < array.length; i++) {
            if(map.containsKey(array[i])){
                Integer integer = map.get(array[i]);
                if(integer+1>mid){
                    return array[i];
                }
                map.put(array[i],integer+1);
            }else {
                map.put(array[i],1);
            }
        }
        return 0;
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        //候选众数的值
        int win = -1;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(win==-1){
                win = array[i];
                count = 1;
            }else {
                if(win!=array[i]){
                    count--;
                }else {
                    count++;
                }
            }
            if(count==0){
                win = -1;
            }
        }

        double mid = (double)array.length/2f;
        int num=0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == win){
                num++;
            }
        }
        return num>mid?win:0;
    }


        public static void main(String[] args) {
        JZ28 jz28 = new JZ28();
        int[] arr = {1,2,3,3};
        int i = jz28.MoreThanHalfNum_Solution(arr);
        System.out.println();
    }
}
