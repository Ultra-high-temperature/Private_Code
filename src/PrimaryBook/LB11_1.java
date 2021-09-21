package PrimaryBook;

public class LB11_1 {
    //原地算法旋转数组 指每个元素都挪一个位置
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length / 2; i++) {
            round(i, matrix, matrix.length - 2 * i);
        }
    }

    private void round(int start, int[][] matrix, int maxLen) {
        int x = start;
        int y = start;
        int value = matrix[x][y];
        int tempValue = 0;
        int flag = 0;
        int num = 0;
        while (true) {
            if (num < maxLen - 1) {
                num++;
            } else {
                num = 1;
                flag++;
            }
            if (flag == 4) {
                break;
            }
            switch (flag) {
                case 0:
                    tempValue = matrix[x][++y];
                    break;
                case 1:
                    tempValue = matrix[++x][y];
                    break;
                case 2:
                    tempValue = matrix[x][--y];
                    break;
                case 3:
                    tempValue = matrix[--x][y];
                    break;
            }
            matrix[x][y] = value;
            value = tempValue;
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
        LB11_1 lb11 = new LB11_1();
        lb11.rotate(ints3);
        System.out.printf("");
    }
}
