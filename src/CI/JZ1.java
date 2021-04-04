package CI;

//https://www.nowcoder.com/questionTerminal/abc3fe2ce8e146608e868a70efebf62e
public class JZ1 {
    //暴力解法
    public boolean Find0(int target, int [][] array) {
        int x = array.length;
        int y = array[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(array[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }

    //从左下角开始查找，从上往下，从左往右都是递增的
    //比当前值大的往右找，比当前值小的往左找
    //出了边界就false
    public boolean Find(int target, int [][] array) {
        int x = array.length;
        int y = array[0].length;
        int i = x-1;
        int j = 0;
        while (i>=0&&j<=y-1){
            if(array[i][j]==target){
                return true;
            }else if(array[i][j]<target){
                //目标比当前值大的往右找
                j++;
            }else {
                //目标比当前值小的往上找
                i--;
            }
        }
        return false;
    }


        public static void main(String[] args) {
        int[][] a = {{1,2,3},{7,8,9}};
        JZ1 jz1 = new JZ1();
        jz1.Find(6,a);
    }
}
