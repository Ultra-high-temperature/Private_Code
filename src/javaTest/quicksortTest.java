package javaTest;

public class quicksortTest {

    static void quicksort(int[] array, int start, int end) {
        int i = start;
        int j = end;
        int begin = array[start];
        while (i != j) {
            while (array[j] >= begin && i < j) {
                j--;
            }
            while (array[i] <= begin && i < j) {
                i++;
            }

            if (i < j) {
                //交换 array[j] array[i]的值
                array[j] += array[i];
                array[i] = array[j] - array[i];
                array[j] -= array[i];
            }
        }

        if (start < i) {
            //交换start 和 i或者j 对应位置的值
            array[start] += array[i];
            array[i] = array[start] - array[i];
            array[start] -= array[i];
        }

        if (i - 1 > start) {
            quicksort(array, start, i - 1);
        }
        if (i + 1 < end) {
            quicksort(array, i + 1, end);
        }
    }

    void quicksort(int l, int r,int[] nums)
    {
        if(l >= r){return;}
        int pivot = nums[l];
        int i = l; int j = r;
        while(i < j)
        {
            while(nums[j] >= pivot &&i < j)
            {
                j--;
            }
            while(nums[i] <= pivot && i < j)
            {
                i++;
            }
            if(i<j){swap(nums,i,j);}
        }
        swap(nums,l, i);
        quicksort(l,i-1,nums);
        quicksort(i+1,r,nums);
    }

    private void swap(int[] nums, int i, int j) {
    }

    public static void main(String[] args) {
        int[] array = {6, 5, 8, 9, 14, 2, 32, 7, 3, 9};
        int length = array.length;
        quicksort(array, 0, length - 1);
        System.out.println();
    }
}
