package javaTest;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest implements Comparable<MapTest>{
    private TreeMap<String,Integer> treeMapTest(){
        TreeMap<MapTest,Integer> treeMap = new TreeMap<>();
        treeMap.put(new MapTest(),2);
        return null;
    }
    @Override
    public int compareTo(MapTest o) {
        return 0;
    }

    private ConcurrentHashMap<String,Integer> concurrentHashMapTest(){
        ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap<>();
        map.put("12",3);
        map.get("12");
        return null;
    }

    private LinkedHashMap<String,Integer> LinkedHashMapTest(){
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        map.put("12",3);
        map.get("12");
        return null;
    }

    public static void main(String[] args) {
//        Collections.synchronizedCollection()
    }


}
