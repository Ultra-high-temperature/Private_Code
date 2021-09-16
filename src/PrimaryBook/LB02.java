package PrimaryBook;

public class LB02 {
     public int maxProfit0(int[] prices) {
        int[][] dp = new int[2][prices.length];
        dp[0][0] = 0;
        dp[1][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[0][i] = max(dp[1][i-1]+prices[i],dp[0][i-1]);
            dp[1][i] = max(dp[0][i-1]-prices[i],dp[1][i-1]);
        }
        return dp[0][prices.length-1];
    }

    public int maxProfit(int[] prices) {
        //int[][] dp = new int[2][prices.length];
        int dp0 = 0;
        int dp1 = -prices[0];

        int beforeDp0 = 0;
        for (int i = 1; i < prices.length; i++) {
            beforeDp0 = dp0;
            dp0 = dp1+prices[i]>dp0?dp1+prices[i]:dp0;
            dp1 = beforeDp0-prices[i]>dp1?beforeDp0-prices[i]:dp1;
        }
        return dp0;
    }

    static int max(int a,int b){
        return a>b?a:b;
    }

    public static void main(String[] args) {
        LB02 lb02 = new LB02();
        int i = lb02.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.printf("");
    }
}
