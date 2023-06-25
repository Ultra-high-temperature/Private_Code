package javaTest;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class streamTest {



    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add((double) i);
//            list.add(Double.valueOf(Math.random()));
        }

        AtomicReference<Double> i = new AtomicReference<>((double) 0);
        long count = list.stream().filter(w -> w > 0.6555555).count();
        long count1 = list.stream().filter(w -> w > 50).skip(10).count();
        // 顺序影响过滤的结果 上式能实现跳过大于五十的前十个数字的作用
        // 下式跳过了前十个数字再找大于50的数字
        long count2 = list.stream().skip(10).filter(w -> w > 50).count();
        Map<Double, Double> collect = list.stream().filter(w -> w % 2 == 0).collect(Collectors.toMap((w) -> {
//            double i = 0;
                    return i.getAndSet(new Double((double) (i.get() + 1)));
                }
                , w -> w));
        Set<Double> collect1 = list.stream().filter(w -> w % 2 == 0).map(w -> w / 10).collect(Collectors.toSet());
        System.out.println(count);

        //使用int数组只能转换出List<int[]>
        List<int[]> ints = Arrays.asList(new int[]{0, 1, 2, 3, 4, 5, 6});
        //使用Integer数组能转换出List<Integer>
        List<Integer> integers = Arrays.asList(new Integer[]{0, 1, 2, 3, 4, 5, 6});
        //其中一部分原因应该是基本类型数组本身就是对象，但是基本数据类型不是对象，导致取数取不到。

        List<Integer> integers2 = Arrays.asList(new Integer[]{0, 1, 2, 3, 4, 5, 6});

        //创建一个数组的数组
        List<List<Integer>> lists = Arrays.asList(integers, integers2);
        //flatMap将嵌套的list通过Stream整合成一条steam流
        long count3 = lists.stream()
                .flatMap(e -> e.stream())
                .filter(e -> e > 2)
                .count();

        System.out.printf("" + addUp(integers.stream()));

        System.out.printf("\n获取hashcode和执行tostring的数据\n");
        getHashCodeAndNumber(integers2);

        convertList();
    }

    static int addUp(Stream<Integer> numbers) {
        return numbers.reduce(0, (a, b) -> a + b);
    }


    static <T> List<String> getHashCodeAndNumber2(List<T> list) {
        //为何范形能通过编译？大概是因为泛型是编译时参数，但为什么同样是编译期，List list跑不通呢？
        List<String> collect2 = list.stream()
                .flatMap(e -> Stream.of(String.valueOf(e.hashCode())))
                .collect(toList());

        return collect2;
    }

    static List<String> getHashCodeAndNumber(List list) {

        List<Integer> integers = list;

        //为何List<Object> 作为入参，flatMap无法转换出Stream<String>流呢
        Stream stream1 = list.stream()
                .flatMap(e -> Stream.of(String.valueOf(e.hashCode())));

        Stream<String> stringStream = integers.stream()
                .flatMap(e -> Stream.of(String.valueOf(e.hashCode())));

        //强制类型转换后就出的来 流只能用一次，用一次就会关闭。
//        Object collect = stream1.collect(toList());
//        List<String> collect1 = ((Stream<String>) stream1).collect(toList());

        //无法通过编译 java: 不兼容的类型: java.lang.Object无法转换为java.util.List<java.lang.Object>
//        List<Object> collect2 = list.stream()
//                .flatMap(e -> Stream.of(String.valueOf(e.hashCode())))
//                .collect(toList());

        //

//        step1 为什么 Stream<Object>流作为参数时，flatMap只能返回stream<Object>，而不能返回Stream<String>
        Stream stream = list.stream()
                .flatMap(e -> Stream.of(String.valueOf(e.hashCode())));

//        step2 为什么 Stream<Object>流作为参数时，collect会返回一个Object，而非List<Object>
        Object collect = stream.collect(toList());

        return (List<String>) list.stream()
                .flatMap(e -> Stream.of(String.valueOf(e.hashCode())))
                .collect(toList());
    }

    void t() {
        List integers2 = Arrays.asList(new Integer[]{0, 1, 2, 3, 4, 5, 6});
        Object collect2 = integers2.stream()
                .flatMap(e -> Stream.of(String.valueOf(e.hashCode())))
                .collect(toList());
    }

    static void convertList(){
//        形如 [John → 3, Paul → 2, George → 1] 的 Map：
        Stream<String> names = Stream.of("John", "Paul", "George", "John",
                "Paul", "John");

        Map<String, Long> collect = names.collect(groupingBy(n -> n, counting()));

        String s1 = names.reduce(new StringBuilder("["), ((stringBuilder, s) -> {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(" , ");
            }
            stringBuilder.append(s);
            return stringBuilder;
        }), (x, y) -> x.append(y)).append("]").toString();

        System.out.printf(s1);
    }


    static void myGroupBytest(){
        Stream<String> names = Stream.of("John", "Paul", "George", "John",
                "Paul", "John");
        names.collect(new MyGroupByCollector<>());
    }


}
