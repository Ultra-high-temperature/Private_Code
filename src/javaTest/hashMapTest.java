package javaTest;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class hashMapTest {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(123,"string1");
        map.get(123);

        Hashtable<Integer, String> map2 = new Hashtable<>();
        map.put(123,"string1");
        map2.get(123);

        ConcurrentHashMap<Integer, String> map3 = new ConcurrentHashMap<>();

        Thread thread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {

                    }
                }
        );
        thread.start();
        thread.run();

        if(1==3)
        System.out.println("123");
        List array = Arrays.asList(new Integer[]{1, 2, 3});
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.contains(1);
        set.size();
        System.out.printf("");
    }
}
