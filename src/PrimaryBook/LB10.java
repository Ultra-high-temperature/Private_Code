package PrimaryBook;

import java.util.HashSet;

public class LB10 {
    public boolean isValidSudoku(char[][] board) {
        char point = '.';
        int xMax = board[0].length;
        int yMax = board.length;
        HashSet<Character> set = new HashSet<>();
        for (int x = 0; x < xMax; x++) {
            set.clear();
            for (int y = 0; y < yMax; y++) {
                if(board[x][y]!='.'){
                    if(set.contains(board[x][y])==false){
                        set.add(board[x][y]);
                    }else {
                        return false;
                    }
                }
            }
        }
        for (int y = 0; y < yMax; y++) {
            set.clear();
            for (int x = 0; x < xMax; x++) {
                if(board[x][y]!='.'){
                    if(set.contains(board[x][y])==false){
                        set.add(board[x][y]);
                    }else {
                        return false;
                    }
                }
            }
        }
        for (int x = 0; x < xMax; x+=3) {
            for (int y = 0; y <yMax; y+=3) {
                if(check(x,y,board) == false){
                    return false;
                }
            }
        }
        return true;
    }
    boolean check(int x , int y,char[][] board){
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[x+i][y+j]=='.') continue;
                if(set.contains(board[x+i][y+j])){
                    return false;
                }else {
                    set.add(board[x+i][y+j]);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] chars = {{'1', '2', '3'},{'4', '5', '6'},{'7', '8', '9'}};
        LB10 lb10 = new LB10();
        final boolean validSudoku = lb10.isValidSudoku(chars);
        System.out.printf("");
    }
}
