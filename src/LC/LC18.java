package LC;

import java.util.Arrays;

public class LC18 {
    public int minCut (String s) {
        if (s.length()==0||s.length()==1){
            return 0;
        }

        int[] dp =new int[200];
        //初始化，最少为
        for (int i = 0; i < dp.length; i++) {
            dp[i]=i;
        }

        int length = s.length();
        for (int i = 1; i < length; i++) {
            for (int j = i; j >= 1 ; j--) {
                if(isPalindrome(s,j,i)){
                    if(dp[i]>(dp[j-1]+1)){
                        dp[i]=dp[j-1]+1;
                    }
                }
            }
            if(isPalindrome(s,0,i)){
                dp[i]=0;
            }
        }

        return dp[length-1];
    }

    // start end 都包含
    boolean isPalindrome(String s,int start,int end){
        while (start<=end){
            if (s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


    public static void main(String[] args) {
        LC18 lc18 = new LC18();
        int min = lc18.minCut("abcbaaba");
        System.out.printf(String.valueOf(min));
    }
}
