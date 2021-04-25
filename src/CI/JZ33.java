package CI;

public class JZ33 {
    public int GetUglyNumber_Solution(int index) {
        if(index == 0) return 0;
        int arr[] = new int[index];
        arr[0] = 1;
        int p2 = 0;//乘2的次数
        int p3 = 0;//乘3的次数
        int p5 = 0;//乘5的次数
        for (int i = 1; i < index; i++) {
            int min = Math.min(arr[p2] * 2, Math.min(arr[p3] * 3, arr[p5] * 5));
            arr[i] = min;
            if(min==arr[p2] * 2){
                p2++;
            }
            if(min==arr[p3] * 3){
                p3++;
            }
            if(min==arr[p5] * 5){
                p5++;
            }
        }
        return arr[index-1];
    }

    public static void main(String[] args) {
        JZ33 jz33 = new JZ33();
        int i = jz33.GetUglyNumber_Solution(0);
        System.out.printf("");
    }
}
