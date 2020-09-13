package javaTest;

import java.util.HashSet;

public class SetLearn{
    public static void main(String[] args) {
        try {
            System.out.println(Math.round(-11.52));
            char[] a={'d','c','b'};
            String b= "bcd";
            set(a,b);
            System.out.println(a);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println("555");
        }
    }
    public static void set(char[] a, String b){
        b="test";
        a[0]='a';
    }
}
