package CI;

public class JZ66 {
    int[] move = {1, 0, -1, 0, 1};
    int count = 0;

    public int movingCount(int threshold, int rows, int cols) {
        int[][] arr = new int[rows][cols];
        dfs(arr, 0, 0);
        return count;
    }

    private void dfs(int[][] arr, int x, int y) {
        if (x >= arr.length || x < 0 || y >= arr[0].length || y < 0) {
            return;
        }
        if (arr[x][y] == 0) {
            count++;
            arr[x][y] = 1;
            for (int i = 0; i < move.length - 2; i++) {
                dfs(arr, x + move[i], y + move[i + 1]);
            }
        }
    }

    boolean check(int maxValue, int x, int y) {
        int sum = 0;
        while (x > 10) {
            sum += x % 10;
            x /= 10;
        }
        sum += x;
        while (y > 10) {
            sum += y % 10;
            y /= 10;
        }
        sum += y;
        if (sum > maxValue) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        JZ66 jz66 = new JZ66();
        int i = jz66.movingCount(5, 10, 10);
        System.out.println();
    }
}
