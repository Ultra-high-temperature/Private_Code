package javaTest.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    void fuc(String s){

        if(s==null||s.length()==0){
            System.out.println("");
            return;
        }
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if(sb.charAt(i)==chars[i]){
                continue;
            }

            //可供替换的最小位置
            int minIndex = findMin(sb, i);
            if(minIndex!=i){
                String s1 = sb.charAt(minIndex)+"";
                String s2 = sb.charAt(i)+"";
                sb.replace(i,i+1,s1);
                sb.replace(minIndex,minIndex+1,s2);
                break;
            }
        }
        System.out.println(sb);
    }

    int findMin(StringBuilder s,int startIndex){
        int min= startIndex;
        for (int i = startIndex; i <s.length(); i++) {
            if(s.charAt(min)>s.charAt(i)){
                min=i;
            }
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        Main c14 = new Main();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        c14.fuc(s);
    }
}
