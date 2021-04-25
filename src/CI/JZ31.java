package CI;

//https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/mian-shi-ti-43-1n-zheng-shu-zhong-1-chu-xian-de-2/

public class JZ31 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            int num = i;
            while (num>0){
                if(num%10==1){
                    sum++;
                }
                num/=10;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        JZ31 jz31 = new JZ31();
        int i = jz31.NumberOf1Between1AndN_Solution(13);
        System.out.printf(""+i);
    }
}
