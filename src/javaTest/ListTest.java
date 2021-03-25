package javaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListTest {
    public static void main(String[] args) {
//        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList();
        Integer[] arr = {0,1,2,3};

        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(arr));
        nums.add(6);
        nums.add(0,4);
        nums.remove(1);

        int i = 10;
//        while (i){
//
//        }
//        Object
        LinkedList<String> list = new LinkedList<>();
        list.add("123");
        list.add(0,"0");
        list.get(1);
        list.remove("123");
    }
}
