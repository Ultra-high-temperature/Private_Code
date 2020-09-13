package javaTest;

import java.lang.reflect.*;

public class reflectTest {

    public static void main(String[] args) throws Exception{
//        a a = new a();
        Class<?> aClass = Class.forName("test.a");
        reflectTest reflectTest = new reflectTest();

        reflectTest.test2(aClass);
    }


    // 获取某个实例里的值
    void test2(Class aClass) throws Exception{
//        a a = new a();
//        Field i = aClass.getDeclaredField("i");
////        Object o = i.get(a);
//        // 上面代码无法访问到 实例变量 i 因为 i 是私有的，默认访问权限访问不到
//        i.setAccessible(true);
//        // 关掉访问控制
//        Object o = i.get(a);
//        System.out.println(o);
    }

    void test1(Class aClass) throws Exception{
        Object o = aClass.newInstance();
        Field[] fields = aClass.getFields();
        Method[] methods = aClass.getMethods();
        Constructor<?>[] constructors = aClass.getConstructors();
        Class<?> superclass = aClass.getSuperclass();

        String s = Modifier.toString(aClass.getModifiers());

        for (Constructor constructor:
                constructors) {
            Class[] parameterTypes = constructor.getParameterTypes();
            Parameter[] parameters = constructor.getParameters();
        }
//
//        for (Field field:
//             fields) {
//            field.ge
//        }

        System.out.println(fields.toString());
        System.out.println(methods.toString());
        System.out.println(constructors.toString());
        System.out.println(superclass.toString());
//        Constructor constructor=new Constructor<Class<a>>()
    }
}
