package javaTest;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
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
        integers.stream().mapToInt(i -> i).max();


        List<Integer> integers2 = Arrays
                .asList(new Integer[]{-1, 1, 1, 2, 2, 3, 3, 4});
        Map<Boolean, List<Integer>> collect = integers.stream().collect(Collectors.partitioningBy(o -> o > 0));
        String collect1 = integers.stream().map(e -> Integer.toString(e)).collect(Collectors.joining(",", "<", ">"));
        //分组后再嵌套收集器
        Map<Integer, List<Integer>> collect2 = integers2.stream().collect(Collectors.groupingBy(e -> e % 2, Collectors.mapping(a -> a + 10, Collectors.toList())));

        //获得元素的HashCode并进行拼接,生成形如《1,2,3,6》(不使用Join)

        //1.0，纯StreamAPI
        StringBuilder reduce = integers.stream().map(Object::hashCode).map(e -> e + "")
                .reduce(new StringBuilder(), (builder, inte) -> {
                    if (builder.length() > 0) {
                        builder.append(",");
                    }
                    builder.append(inte);
                    return builder;
                }, (l, r) -> l.append(r));
        System.out.println(reduce);

        //2.0委托所有的操作给StringCombiner
        StringCombiner reduce1 = integers.stream()
                .map(e -> String.valueOf(e.hashCode()))
                .reduce(new StringCombiner(",", "<", ">"), StringCombiner::add, StringCombiner::merge);
        System.out.println(reduce1);

        //3.0实现Collector接口
        integers.stream()
                .map(e -> String.valueOf(e.hashCode()))
                .collect(new StringCollector(", ", "[", "]"));
    }
}

class StringCollector implements Collector<String, StringCombiner, String> {

    String prefix;
    String delim;
    String endfix;

    StringCollector(String prefix,
                   String delim,
                   String endfix) {
        this.prefix = prefix;
        this.delim = delim;
        this.endfix = endfix;
    }


    //Supplier工厂
    @Override
    public Supplier<StringCombiner> supplier() {
        return StringCombiner::new;
    }

    @Override
    public BiConsumer<StringCombiner, String> accumulator() {
        return null;
    }

    @Override
    public BinaryOperator<StringCombiner> combiner() {
        return null;
    }

    @Override
    public Function<StringCombiner, String> finisher() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return null;
    }
}

class StringCombiner {

    String prefix;
    String delim;
    String endfix;

    public StringCombiner() {

    }

    @Override
    public String toString() {
        return builder.append(endfix).toString();
    }

    StringBuilder builder = new StringBuilder();

    StringCombiner(String prefix,
                   String delim,
                   String endfix) {
        this.prefix = prefix;
        this.delim = delim;
        this.endfix = endfix;
    }

    public StringCombiner merge(StringCombiner other) {
        builder.append(other.builder);
        return this;
    }

    public StringCombiner add(String element) {
        if (builder.length() > 0) {
            builder.append(prefix);
        } else {
            builder.append(delim);
        }
        builder.append(element);
        return this;
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