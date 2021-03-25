package javaTest;

public class Test3 {

    public static Test3 t1=new Test3();

    {
        System.out.println("blockA");
    }

    static {
        System.out.println("blockB");
    }

    public static void main(String[] args){
        Test3 t2=new Test3();
    }
}