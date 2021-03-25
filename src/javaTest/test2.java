package javaTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class test2 {
    public void fuc(){
        try {
            File file = new File("");
            throw new NullPointerException();
//            file.length();
        }catch (NullPointerException e){
            System.out.println("NullPointerException");
        }catch (Exception e){
            System.out.println("Exception");
        }finally {
            System.out.println("finally");
        }
    }

    public static void main(String[] args) {

        int i = 8;
        int j = 1 << (i);
//        System.out.println(j);
        test2 test2 = new test2();
        test2.fuc();
    }

}
