package CI;

import java.util.Arrays;
import java.util.Stack;

public class JZ65 {
    public boolean hasPath(char[][] matrix, String word) {
        char[][] chars;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == word.charAt(0)) {
                    boolean result = search(matrix, word, i, j, 0);
                    if (result == true) {
                        return true;
                    }
                }
            }
        }
        System.out.println();
        return false;
    }

    private boolean search(char[][] source, String word, int i, int j, int index) {
        if (index == word.length()-1) {
            return true;
        }
        int xMax = source.length;
        int yMax = source[0].length;
        boolean result = false;
        if (result == false && i + 1 < xMax && source[i + 1][j] == word.charAt(index + 1)) {
            char[][] copyArr = copyArr(source);
            copyArr(source);
            copyArr[i + 1][j] =' ';
            result = search(copyArr, word, i + 1, j, index + 1);
        }
        if (result == false && i - 1 >= 0 && source[i - 1][j] == word.charAt(index + 1)) {
            char[][] copyArr = copyArr(source);
            copyArr[i - 1][j] =' ';
            result = search(copyArr, word, i - 1, j, index + 1);
        }
        if (result == false && j + 1 < yMax && source[i][j + 1] == word.charAt(index + 1)) {
            char[][] copyArr = copyArr(source);
            copyArr[i][j+ 1] =' ';
            result = search(copyArr, word, i, j + 1, index + 1);
        }
        if (result == false && j - 1 >= 0 && source[i][j - 1] == word.charAt(index + 1)) {
            char[][] copyArr = copyArr(source);
            copyArr[i][j- 1] =' ';
            result = search(copyArr, word, i, j - 1, index + 1);
        }
        return result;
    }

    private char[][] copyArr(char[][] source) {
        char[][] chars = Arrays.copyOf(source, source.length);
        for (int i = 0; i < chars.length; i++) {
            chars[i] = Arrays.copyOf(source[i], source[i].length);
        }
        return chars;
    }

    public static void main(String[] args) {
        char[][] chars = {{'a', 'b', 'c'}, {'b', 'e', 'd'}, {'f', 'g', 'g'}};
        JZ65 jz65 = new JZ65();
        boolean accede = jz65.hasPath(chars, "abcdebf");
        System.out.println();
    }
}
