package javaTest.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class c13 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)) ;
        Integer n = Integer.valueOf(reader.readLine());
        String s = reader.readLine();

        int red = 0;
        int blue = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0'){
                red++;
            }else {
                blue++;
            }
        }
        System.out.println(red<blue?red:blue);
    }
}
