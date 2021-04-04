package CI;

//https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3
public class JZ7 {
    //dp数组是多余的，只需要留两个变量储存n-1 和n-2的值就可以了
    public int Fibonacci1(int n) {
        int dp[] = new int[40];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // i1存n-2，i2存n-1
    public int Fibonacci(int n) {
        if(n == 0){
            return 0;
        }
        int i1 = 0;
        int i2 = 1;
        for (int i = 2; i <= n; i++) {
            i2 = i1+i2;
            i1 = i2-i1;
        }
        return i2;
    }

    public static void main(String[] args) {
        JZ7 jz7 = new JZ7();
        int fibonacci = jz7.Fibonacci(4);
        System.out.println(fibonacci);
    }
}
