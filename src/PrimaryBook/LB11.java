package PrimaryBook;

public class LB11 {
    /**
     * 原地算法旋转数组 旋转90度
     */
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        //先上下交换
        for (int i = 0; i < length / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[length - i - 1];
            matrix[length - i - 1] = temp;
        }
        //在按照对角线交换
        for (int i = 0; i < length; ++i) {
            for (int j = i + 1; j < length; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }



    public static void main(String[] args) {
        int[][] ints = {{1, 2}, {3, 4}};
        int[][] ints3 = {{1}};
        int[][] ints2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        LB11 lb11 = new LB11();
        lb11.rotate(ints3);
        System.out.printf("");
    }
}
