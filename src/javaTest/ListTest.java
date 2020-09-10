package javaTest;


import test.stu;

import java.util.ArrayList;

public class ListTest {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 9; i++) {
            list.add("456");
        }
        list.add("456");
        list.add(1);
        list.add(new stu());
        System.out.println('1');
    }
}
