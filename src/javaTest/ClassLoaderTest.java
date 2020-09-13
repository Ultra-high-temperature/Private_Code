package javaTest;

public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader appClassLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(appClassLoader);

        ClassLoader extClassLoader = appClassLoader.getParent();
        System.out.println(extClassLoader);


    }
}
