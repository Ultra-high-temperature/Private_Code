package javaTest.constructor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class B extends A{
    static {
        System.out.println("static b");
    }
    B(){
        System.out.println("constructor b");
    }

    public static void main(String[] args)  {
        A ab = new B();
        ab = new B();
//        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("text.txt"));
//        new BufferedReader(new FileInputStream("text.txt"));
        int a = 3;
        int b = a++ + ++a;
        System.out.println(b+"");
    }
}
