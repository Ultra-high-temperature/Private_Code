package javaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class stringTest {

    public static void main(String[] args) {
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

    String s(){
        StringBuffer s = new StringBuffer();
        s.append("");
        StringBuilder s2 = new StringBuilder();
        s2.append("");

        String s1 = s2.toString();
        s1.intern();
        return null;
    }
}
