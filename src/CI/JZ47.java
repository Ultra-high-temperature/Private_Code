package CI;

public class JZ47 {
    int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (sum>0)&&((sum+=Sum_Solution(--n))>0);
        return sum;
    }

    public static void main(String[] args) {
        JZ47 jz47 = new JZ47();
        jz47.Sum_Solution(3);
    }
}
