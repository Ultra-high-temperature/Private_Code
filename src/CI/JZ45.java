package CI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class JZ45 {
    public boolean IsContinuous(int [] numbers) {
        fastSort(numbers,0, numbers.length-1);
        int start = 0;
        int end = 0;
        int zeroNum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i]==0){
                zeroNum++;
                start++;
            }else {
                break;
            }
        }
        end = numbers.length-1;
        if(numbers[end]==numbers[start]&&start!=end){
            return false;
        }
        //end-start+1代表填满[start,end]区间需要的元素数量，超过length代表填不满
        return numbers[end]-numbers[start]+1<=numbers.length?true:false;
    }

    private void fastSort(int[] arr,int start,int end){
        if(start>=end){
            return;
        }
        int l = start;
        int r = end;
        int mid = start;
        while (l<r){
            while (l<r&&arr[r]>=arr[mid]){
                r--;
            }
            while (l<r&&arr[l]<=arr[mid]){
                l++;
            }
            swap(arr,l,r);
        }
        swap(arr,l,mid);
        fastSort(arr, start, mid-1);
        fastSort(arr, mid+1, end);
    }
    private void swap(int[] arr,int start,int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void main(String[] args) {
        JZ45 jz45 = new JZ45();
        int[] a = {0,0,1,1};
        boolean b = jz45.IsContinuous(a);
        System.out.printf("");
    }
}
