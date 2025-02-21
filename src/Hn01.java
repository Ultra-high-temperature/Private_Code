// 导入所需的库
import java.util.*;

public class Hn01 {
    // 定义一个内部类来存储结果
    public static class Result {
        int num;  // 新字符串的数量
        List<String> strings;  // 新生成的字符串集合

        // 构造函数
        public Result(int num, List<String> strings) {
            this.num = num;
            this.strings = strings;
        }
    }

    // 主要的函数，使用动态规划求解问题
    public static Result minNumberOfStrings(List<String> A, int B) {
        int n = A.size();  // 字符串的数量
        int[] dp = new int[n + 1];  // 动态规划数组，dp[i]表示前i个字符串可以用最少的新字符串表示
        int[] start = new int[n + 1];  // 记录每一个新字符串的开始位置
        Arrays.fill(dp, Integer.MAX_VALUE);  // 初始化dp数组
        dp[0] = 0;  // 没有字符串需要0个新字符串

        // 遍历每一个字符串
        for (int i = 1; i <= n; i++) {
            int length = 0;  // 当前新字符串的长度
            int j = i;  // 当前新字符串的开始位置
            // 尝试将第j个字符串添加到当前的新字符串中
            while (j > 0 && length + A.get(j - 1).length() <= B) {
                length += A.get(j - 1).length();  // 更新当前新字符串的长度
                // 如果需要创建一个新的字符串，更新dp[i]和start[i]
                if (dp[j - 1] + 1 < dp[i]) {
                    dp[i] = dp[j - 1] + 1;
                    start[i] = j;
                }
                j--;  // 更新当前新字符串的开始位置
            }
        }

        // 根据开始位置，获取新生成的字符串集合
        List<String> strings = new ArrayList<>();
        int i = n;  // 从最后一个字符串开始
        while (i > 0) {
            StringBuilder sb = new StringBuilder();  // 用于拼接字符串
            // 将第start[i]个到第i个字符串拼接成一个新的字符串
            for (int k = start[i] - 1; k < i; k++) {
                sb.append(A.get(k));
            }
            strings.add(sb.toString());  // 将新的字符串添加到列表中
            i = start[i] - 1;  // 更新i
        }
        Collections.reverse(strings);  // 反转字符串列表，因为我们是从后往前添加的

        // 返回结果
        return new Result(dp[n], strings);
    }

    // 主函数，用于测试
    public static void main(String[] args) {
        List<String> A = Arrays.asList("abc", "fgh", "ij", "lm", "op");  // 字符串列表
        int B = 5;  // 指定的长度
        Result result = minNumberOfStrings(A, B);  // 调用函数求解问题
        // 打印结果
        System.out.println("最少需要的新字符串的数量: " + result.num);
        System.out.println("新生成的字符串集合: " + result.strings);
    }
}
