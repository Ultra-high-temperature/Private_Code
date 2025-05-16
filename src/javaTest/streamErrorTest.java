package javaTest;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class streamErrorTest {
    private static class QuotaValue{
        public Long id;

        public QuotaValue(Long id) {
            this.id = id;
        }
    }

    public static void main(String[] args) {

//        ArrayList<QuotaValue> quotaValues = new ArrayList<>();
//        quotaValues.add(new QuotaValue(0l));
//        quotaValues.add(new QuotaValue(1l));
////        quotaValues.add(new QuotaValue(1l));
//        quotaValues.add(new QuotaValue(null));
//        quotaValues.add(null);
//
//        Map<Long, QuotaValue> collect = quotaValues.stream().collect(Collectors.toMap(m -> m.id, Function.identity()));
        List<String> strings = Arrays.asList("hn", "h2");
        String format = String.format("test%s,test%s", strings.toArray());
        System.out.printf(format);
    }
}
