package javaTest.c;

import java.util.Stack;

public class c7 {

    int reverse(int x) {
        String num = String.valueOf(x);
        boolean f=false;
        if(num.charAt(0)=='-'){
            num=num.substring(1);
            f=true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            stack.push(num.charAt(i));
        }
        int size=stack.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(stack.pop());
        }
        String s = stringBuilder.toString();
        if (f){
            s="-"+s;
        }
        return Integer.valueOf(s);
    }

    public static void main(String[] args) {
        int reverse = new c7().reverse(-123);
        System.out.println(reverse);
    }
}
