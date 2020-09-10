package hn;

import java.util.ArrayList;
import java.util.Collections;

public class c6 {
    public String convert (String s, int nRows) {
        int length = s.length();
        int column = length/2+10;
        Character[][] array=new Character[nRows][column];

        if (s.isEmpty()||s==null){
            return "";
        }
        boolean b =true;
        int r=0;int c=0;

        for (int i = 0; i < s.length(); i++) {
            if(b){
                array[r][c]=  s.charAt(i);
                r++;
                if(r>=nRows){
                    r--;
                    b=false;
                }
            }else {
                c++;
                if(r-1>=0){
                    r--;
                }
                array[r][c]=  s.charAt(i);
                if(r<=0){
                    r++;
                    b=true;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < column; j++) {
                if(array[i][j]!=null){
                    result.append(array[i][j]);
                }
            }
        }
        String s1 = result.toString();
        return s1;
    }

    public static void main(String[] args) {
        String a = new c6().convert("AB", 1);
//        System.out.println(a);

    }
}
