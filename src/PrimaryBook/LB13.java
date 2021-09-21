package PrimaryBook;

public class LB13 {
    public int reverse(int x) {
        char[] minCharArr = String.valueOf(-2147483648).toCharArray();
        char[] maxCharArr = String.valueOf(2147483647).toCharArray();
        //当前值需要校验越界 高位与最值相同的情况
        char[] s = Integer.toString(x).toCharArray();

        if (x > 0) {
            for (int i = 0; i < s.length / 2; i++) {
                char t = s[i];
                s[i] = s[s.length - 1 - i];
                s[s.length - 1 - i] = t;
            }
            if(s.length == maxCharArr.length){
                for (int i = 0; i < s.length; i++) {
                    if(s[i]>maxCharArr[i]){
                        return 0;
                    }
                }
            }
        } else if (x < 0) {
            int i = 1;
            int j = s.length - 1;
            while (i < j) {
                char t = s[i];
                s[i] = s[j];
                s[s.length - i] = t;
                i++;
                j--;
            }
            if(s.length == minCharArr.length){
                for (i = 0; i < s.length; i++) {
                    if(s[i]>minCharArr[i]){
                        return 0;
                    }else if(s[i]<minCharArr[i]){
                        break;
                    }
                }
            }
        }
        return Integer.parseInt(String.valueOf(s));
    }

    public static void main(String[] args) {
        LB13 lb13 = new LB13();
        int reverse = lb13.reverse(-2147483412);
//        int reverse = lb13.reverse(-1563847412);
//        int reverse = lb13.reverse(2147483647);
//        int reverse2 = lb13.reverse(-2147483648);
        System.out.printf("");
    }
}
