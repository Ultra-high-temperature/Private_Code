package javaTest;

import java.util.Map;
import java.util.stream.Stream;

public class CollectorTest {
    public static void main(String[] args) {
        myGroupBytest();
    }

    static void myGroupBytest(){
        Stream<String> names = Stream.of("John", "Paul", "George", "John",
                "Paul", "John");
        MyGroupByCollector<Integer> objectMyGroupByCollector = new MyGroupByCollector<>();
        Map<String, Integer> collect = names.collect(new MyGroupByCollector<>());
        System.out.printf(collect.size()+"");
    }
}



