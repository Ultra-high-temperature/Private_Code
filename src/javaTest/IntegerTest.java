package javaTest;

public class IntegerTest {
    public static void main(String[] args) {
        //i2和i3是同一个对象，i1、i4不是
        Integer i1 = new Integer(1);
        Integer i4 = new Integer(1);
        Integer i2 = 1;
        Integer i3 = Integer.valueOf(1);
        System.out.println();
    }
}
