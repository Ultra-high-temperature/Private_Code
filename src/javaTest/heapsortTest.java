package javaTest;

public class heapsortTest {

    // 升序排序 构造大顶堆
    static void heapsort(int root, int[] array) {
        int i = (array.length - 1) / 2 - 1;
        int length = array.length - 1;
        while (length > 0 && i >= -1) {
            //从后往前 构造大顶堆
            buildBigHeap(array, i, length);
            // 完成了一次大顶堆构造
            swap(array, root, length);
            length--;
            i = length / 2 - 1;
        }
    }

    private static void buildBigHeap(int[] array, int i, int length) {
        // i是最后一个非叶子节点
        // 从后往前 构造大顶堆
        while (i >= 0) {
            int l = 2 * i + 1;
            int r = 2 * i + 2;

            if (array[l] > array[i] && l < length) {
                swap(array, l, i);
                //判断子节点是否是非叶子节点，若是则需要继续在子节点处构建大顶堆
                if (2 * l + 1 <= array.length - 1) {
                    adjustHeap(array, l, length);
                }
            }
            if (array[r] > array[i] && r <= length) {
                swap(array, r, i);
                if (2 * r + 1 <= array.length - 1) {
                    adjustHeap(array, r, length);
                }
            }
            i--;
        }
    }

    static void adjustHeap(int[] array, int start, int length) {
        // 从上往下 调整大顶堆
        int l = 2 * start + 1;
        int r = 2 * start + 2;

        if (array[l] > array[start] && l < length) {
            swap(array, l, start);
            //判断子节点是否是非叶子节点，若是则需要继续在子节点处构建大顶堆
            if (2 * l + 1 <= array.length - 1) {
                adjustHeap(array, l, length);
            }
        }
        if (r < length && array[r] > array[start]) {
            swap(array, r, start);
            if (2 * r + 1 <= array.length - 1) {
                adjustHeap(array, r, length);
            }
        }
    }

    static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        int[] array = {6, 5, 8, 9, 14, 2, 32, 7, 3, 9};
        int length = array.length;
        heapsort(0, array);
        System.out.println();
    }
}
