package javaTest;

public class ParamTest {

    void method(String... args){
        System.out.println(args.length);
        for (String str:
             args) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        ParamTest paramTest = new ParamTest();
        paramTest.method("string","str");
    }
}
