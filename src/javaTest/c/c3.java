package javaTest.c;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class c3 {

    public int lengthOfLongestSubstring (String s) {

        HashSet set=new HashSet();
        int max=0;
        int now=0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = j; i < s.length(); i++) {
                if(set.contains(s.charAt(i))==false){
                    set.add(s.charAt(i));
                }else {
                    if(max<set.size()){
                        max=set.size();
                    }
                    set.clear();
                    break;
                }
            }
        }

        return max;
    }


    public static void main(String[] args) {
        String s="wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
        System.out.println(new c3().lengthOfLongestSubstring(s));

        }
}
