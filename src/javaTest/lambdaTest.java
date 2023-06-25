package javaTest;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class lambdaTest {
    public static void main(String[] args) {
        Form form = new Form();
        form.registerListener(x -> x == false);
//        无法推断是调用到哪个接口，很奇怪。
//        form.registerListener(x-> System.out.println(x));
        form.registerListener((Operation) x -> System.out.println(x));

        List<Integer> integers = Arrays.asList(new Integer[]{-1, 2, 3, 4});
        Stream<Integer> integerStream = integers.stream().filter(
                e -> {
                    System.out.println(e);
                    return e % 2 == 0;
                }
        );
        integerStream.count();

        //传入比较器，指定通过字符数量进行大小对比
        Optional<Integer> max = integers.stream().max(Comparator.comparing(x -> String.valueOf(x).length()));
        Optional<Integer> max2 = integers.stream().max(Comparator.comparing(x -> x.hashCode()));

        //stream流处理int类型数据进行特殊处理降低开销
        OptionalInt max1 = integers.stream().mapToInt(i -> i).max();
        max1.getAsInt();

        System.out.println(max.get());
        System.out.println(max2.get());
        integers.stream().mapToInt(i->i).max();
    }
}

class Form {

//    Predicate<Boolean> msgId   T->Predicate->Boolean
//    Operation o                Boolean->Predicate->void
    //类型推断什么时候失效？

    void registerListener(Predicate<Boolean> msgId) {
        msgId.test(true);
    }

    void registerListener(Operation o) {
        o.doAny(true);
    }
}

interface Operation {
    void doAny(Boolean b);
}