package javaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class stringTest {

    public static void main(String[] args) {
//        String s = "123456";
//        int i = s.compareTo("123999");
//        System.out.println(i);
//        if(s.startsWith("123"));

//        read_data:
//        for (int j = 0; j < 5; j++) {
//            for (int k = 0; k < 5; k++) {
//                if(j==1&&k==3){
//                    break read_data;
//                }
//            }
//        }

        ArrayList<Integer> arrayList = new ArrayList(Arrays.asList(1,2,3,5,6));
        Collections.synchronizedList(arrayList);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            Integer next = (Integer) iterator.next();
            if(next==3){
                iterator.remove();
            }
        }
        Integer a = 799999999;
        Integer b = 799999999;
        Integer c = new Integer(7);
        System.out.println(a.equals(b));
    }
}
