package javaTest.constructor;

public class A {
    static {
        System.out.println("static a");
    }
    A(){
        System.out.println("constructor a");
    }

    void model1(String s, Integer i) {

    }

    void model1(Integer i,String s) {

    }

    public static void main(String[] args){
        Object o=new Object(){
            public boolean equals(Object obj){
                return true;
            }
        };
        System.out.println(o.equals("“Fred”"));

    }
}
