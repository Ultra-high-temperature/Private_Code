package LC;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// 思路 用arraylist+map存位置，每当找到'O'就对图进行遍历并标记'O'为中间状态'-'，
// 如果遍历中途未发现到达边界，则变为'X'
// 遍历结束后，将中间状态回退到'O'
public class LC20 {
    private class node{
        public int x;
        public int y;
        public node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    public void solve(char[][] board) {

        int y = board.length;
        int x = board[0].length;
        if(x<=1||y<=1){
            return;
        }
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(board[y][x]=='O'){
                    tuAn(x,y,board);
                }
            }
        }
    }

    //遍历图 找到相连的'O'
    void tuAn(int x, int y,char[][] board){
        int MAXy = board.length;
        int MAXx = board[0].length;
        List<node> nodeList = new ArrayList<>();
        int i = 0;
        // 如果遍历中途发现到达边界，则保持中间状态，否则变为x
        nodeList.add(new node(x,y));
        board[y][x]='-';
        boolean toX = true;
        while (i<nodeList.size()){
            if(x+1<MAXx)

            if(board[y+1][x]=='O'){

            }

            if(board[y+1][x]=='O'){

            }

            if(board[y+1][x]=='O'){

            }

            if(board[y+1][x]=='O'){

            }
        }
    }

    void cl(ArrayList<Map.Entry> list,char c,char[][] board){
        for (Map.Entry m:
             list) {

        }
    }

    public static void main(String[] args) {
        char[][] arr1 = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'O','X','X','X'}};
        LC20 lc20 = new LC20();
        lc20.solve(arr1);
    }
}
