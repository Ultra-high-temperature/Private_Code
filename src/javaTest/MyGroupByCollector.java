package javaTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyGroupByCollector<T, R extends Map<T, Integer>> implements Collector {

    @Override
    public Supplier<MyGroupByCollector.GroupClass> supplier() {
        return MyGroupByCollector.GroupClass::new;
    }

    @Override
    public BiConsumer<MyGroupByCollector.GroupClass,T> accumulator() {
        return MyGroupByCollector.GroupClass::append;
    }

    @Override
    public BinaryOperator<MyGroupByCollector.GroupClass> combiner() {
        return MyGroupByCollector.GroupClass::merge;
    }

    @Override
    public Function<MyGroupByCollector.GroupClass,Map<T, Integer>> finisher() {
        return MyGroupByCollector.GroupClass::getMap;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return null;
    }

    class GroupClass {

        public GroupClass(){};
        public Map<T, Integer> map = new HashMap();

        public void append(T t) {
            Integer integer = map.computeIfAbsent(t, (v) -> 0);
            map.put(t,integer+1);
        }

        public GroupClass merge(GroupClass groupClass){
            Map<T, Integer> hashMap = groupClass.map;
            Map<T, Integer> collect = Stream.of(map, hashMap)
                    .flatMap(m -> m.entrySet().stream())
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            Integer::sum
                    ));
            map = collect;
            return this;
        }

        public Map<T, Integer> getMap(){
            return map;
        }
    }

}

