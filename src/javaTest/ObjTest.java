package javaTest;

import java.util.ArrayList;
import java.util.HashMap;

public class ObjTest {


    public static void main(String[] args) {
        Object[] oj =new Object[]{};
        HashMap<String, Object[]> map = new HashMap<>();
        map.put("0",oj);
        Object[] objects = map.get("0");
        System.out.println();

        classTestB b = new classTestB();
        b.a();
    }
}
