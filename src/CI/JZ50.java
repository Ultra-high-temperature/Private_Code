package CI;

import java.util.HashSet;

//https://www.nowcoder.com/practice/6fe361ede7e54db1b84adc81d09d8524
//在一个长度为n的数组里的所有数字都在0到n-1的范围内。
//数组中某些数字是重复的 请找出数组中任一一个重复的数字
public class JZ50 {

    public int duplicate(int[] numbers) {
        HashSet set = new HashSet();
        for (int i = 0; i < numbers.length; i++) {
            if(set.contains(numbers[i])){
                return numbers[i];
            }
            set.add(numbers[i]);
        }
        return -1;
    }


    //0到n-1 意味着arr[i]==i
    //快排划分区间，判断arr[mid]是否等于mid，不等于就在左边有错位（右边不能确定），
    //等于就在右边找
    //思路不太行
    public int fastSortSearch(int[] arr, int start, int end) {
        if (start == end) {

        }
        int l = start;
        int r = end;
        int mid = l;
        while (l < r) {
            while (l < r && arr[mid] >= arr[r]) {
                r--;
            }
            while (l < r && arr[mid] <= arr[l]) {
                l++;
            }
            swap(arr,l,r);
        }
        swap(arr,l,mid);
        //todo 当遇到 0 1 1 3 4 5 6 这样的数组，查找方向会有问题
        //
        if(l == arr[mid]){

        }
        return -1;
    }

    public void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
