package javaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class streamTest {
    public static void main(String[] args) {
        List<Double> list = new ArrayList();
        for (int i = 0; i < 100; i++) {
            list.add((double)i);
//            list.add(Double.valueOf(Math.random()));
        }

        AtomicReference<Double> i = new AtomicReference<>((double) 0);
        long count = list.stream().filter(w->w>0.6555555).count();
        long count1 = list.stream().filter(w -> w > 50).skip(10).count();
        // 顺序影响过滤的结果 上式能实现跳过大于五十的前十个数字的作用
        // 下式跳过了前十个数字再找大于50的数字
        long count2 = list.stream().skip(10).filter(w -> w > 50).count();
        Map<Double, Double> collect = list.stream().filter(w -> w % 2 == 0).collect(Collectors.toMap((w)->{
//            double i = 0;
            return i.getAndSet(new Double((double) (i.get() + 1)));
                }
        , w -> w));
        Set<Double> collect1 = list.stream().filter(w -> w % 2 == 0).map(w->w/10).collect(Collectors.toSet());
        System.out.println(count);
    }
}
