package hn;

public class sortTest {

    // 升序
    static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {6, 5, 8, 9, 14, 2, 32, 7, 3, 9};
        int length = array.length;
        sort(array);
        System.out.println();
    }
}
