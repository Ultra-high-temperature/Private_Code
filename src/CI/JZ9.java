package CI;

import java.util.HashMap;
import java.util.HashSet;

//https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387
//一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
// 求该青蛙跳上一个n级的台阶总共有多少种跳法。
public class JZ9 {
    //递归解法 dp(n) = 1+dp(n-1)+dp(n-2)+...+dp(1)

    //优化的解法 用map记录这些值
    public int jumpFloorII1(int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        for (int i = 3; i <=target; i++) {
            int sum = 1;
            for (int j = i-1; j > 0; j--) {
                sum = sum+map.get(j);
            }
            map.put(i,sum);
        }
        return map.get(target);
    }

    //优化的解法2
    //dp(n) = 1+dp(n-1)+dp(n-2)+...+dp(1)
    //等价于 dp(n) = 2*dp(n-1)
    public int jumpFloorII(int target) {
        int sum = 1;
        for (int i = 2; i <= target; i++) {
            sum*=2;
        }
        return sum;
    }

    public static void main(String[] args) {
        JZ9 jz9 = new JZ9();
        int i = jz9.jumpFloorII(4);
        System.out.println(i);
    }
}
