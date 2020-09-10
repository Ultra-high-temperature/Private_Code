package javaTest;

public class quicksortTest {

    static void quicksort(int[] array, int start, int end) {
        int i = start;
        int j = end;
//        boolean b = true; //true j 执行 ， false i 执行
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

    public static void main(String[] args) {
        int[] array = {6, 5, 8, 9, 14, 2, 32, 7, 3, 9};
        int length = array.length;
        quicksort(array, 0, length - 1);
        System.out.println();
    }
}
