package javaTest.c;

public class c9 {


    public boolean isPalindrome (int x) {
        if(x<0){
            return false;
        }else if(x<10){
            return true;
        }
        int i;
        for (i = 1; i < Integer.MAX_VALUE; i++) {
            if(x/(int) Math.pow(10,i)<1){
                break;
            }
        }
        i--;
        while (x!=0) {
            int t = x/(int) Math.pow(10,i);//找最高位
            x=x%(int) Math.pow(10,i); //去除最高位
            if((x-t)%10==0){//最高位最低位相减 再除10 取余 如有余数则不相等
                x=(x-t)%10;
                i--;
            }else {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        boolean palindrome = new c9().isPalindrome(1);
        System.out.println(palindrome);
    }
}
