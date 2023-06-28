package javaTest;

import java.util.function.Function;
import java.util.function.Supplier;

public class multiImplementation {
    public static void main(String[] args) {
        multiImplClass obj = new multiImplClass();
        obj.doAny();

        String s = obj.doAny(() -> "123");
        System.out.println(s);

        String s1 = obj.doAny((x) -> "mutiI1".equals(x));
        System.out.println(s1);
//        Assert.assertEquals
    }
}

class multiImplClass implements multiI1,multiI2{

    //多默认方法可能导致参数存在重复项导致编译过不去
    @Override
    public void doAny() {
        multiI1.super.doAny();
        multiI2.super.doAny();
    }
}

interface multiI1{
    default void doAny(){
        System.out.println("mutiI1");
    };

    default String doAny(Supplier<String> supplier){
        return "mutiI1" + supplier.get();
    };
}

interface multiI2{
    default void doAny(){
        System.out.println("multiI2");
    };

    default String doAny(Function<String,Boolean> function){
        return "mutiI1" + function.apply("mutiI1");
    };
}
