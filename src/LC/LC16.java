package LC;

import java.util.Arrays;

public class LC16 {
    public int candy(int[] ratings) {
        if(ratings == null|| ratings.length==0){
            return 0;
        }
        // 过去不怎么办？ 数组怼个90000就够了
        // 优化还是要用arrayList 或者 根据ratings.length 动态分配内存大小然后用Arrays进行初始化
        int[] a = new int[300];
        a[0] = 1;
        for (int i = 1; i < ratings.length; i++) {

            if(ratings[i-1]<ratings[i]){
                a[i]=a[i-1]+1;
            }else if(ratings[i-1]>ratings[i]){
                    a[i]=1;
            }else if (ratings[i-1]==ratings[i]){
                a[i]=1;
            }
        }

        for (int j = ratings.length; j > 0; j--) {
            if ((a[j - 1] <= a[j]) && (ratings[j - 1] > ratings[j])) {
                a[j - 1] = a[j]+1;
            }
        }

        int result = 0;
        for (int i = 0; a[i]!=0; i++) {
            result += a[i];
        }
        return result;
    }


    public static void main(String[] args) {
//        int[] rates = {58,21,72,77,48,9,38,71,68,77,82,47,25,94,89,54,26,54,54,99,64,71,76,63,81,82,60,64,29,51,87,87,72,12,16,20,21,54,43,41,83,77,41,61,72,82,15,50,36,69,49,53,92,77,16,73,12,28,37,41,79,25,80,3,37,48,23,10,55,19,51,38,96,92,99,68,75,14,18,63,35,19,68,28,49,36,53,61,64,91,2,43,68,34,46,57,82,22,67,89};
        int[] rates = {33};
        LC16 lc16 = new LC16();
        int candy = lc16.candy(rates);
        System.out.println(candy);
    }
}
