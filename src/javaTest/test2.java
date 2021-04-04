package javaTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class test2 {
    public void fuc(){
        StringBuffer s = new StringBuffer();
//        ThreadLocal
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

    public static void main(String args[]) {
        String s = "tommy";
        Object o = s;
        sayHello(o); //语句1
        sayHello(s); //语句2
    }
    public static void sayHello(String to) {
        System.out.println(String.format("Hello, %s", to));
    }
    public static void sayHello(Object to) {
        System.out.println(String.format("Welcome, %s", to));
    }

}
