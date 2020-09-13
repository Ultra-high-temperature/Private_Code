package javaTest;

public class Parent {
    static {
        System.out.println("父静态块");
    }

    public Parent() {
        System.out.println("父构造函数");
    }


    public static class Son extends Parent {
        {
            System.out.println("子块");
        }

        static {
            System.out.println("子静态块");
        }

        public Son() {
            System.out.println("子构造函数");
        }

        public static void main(String[] args) {
            new Son();
        }
    }
}