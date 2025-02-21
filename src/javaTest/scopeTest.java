package javaTest;

import java.util.function.Consumer;

public class scopeTest {

    public static void main(String[] args) {

        int i = 0;
        Consumer<String> stringConsumer = (String s) -> {
            System.out.printf("123");
            System.out.printf(""+i);
        };

        stringConsumer.accept("");
    }
}
