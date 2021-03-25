package javaTest;

public class test {

    public static class T1 {
        public int value = 10;
    }

    public static Integer num = 500;
    public static int num2 = 500;
    public static String string = "5000";

    public static void cnum(int value){
        value=11;
    }

    public static void cnum2(Integer value){
        value=11;
    }

    public static void str(String s){
        s = s+1;
    }

    public static void t1Test(T1 s){
        s = new T1();
    }

    public static void main(String[] args) {

        int[] a = new int[1000];

        Double i  = 1d;
        i.intValue();
        cnum(num);
        cnum2(num2);
        str(string);
        System.out.println(num+num2+string);
        T1 t1 = new T1();
        t1.value = 100;
        t1Test(t1);
        System.out.println(t1.value);

        int value1= 5;
        int value2= 5;

        System.out.println("value1*value2："+value1*value2);
        System.out.println("value1/value2："+value1/value2);
        System.out.println("value1+value2："+value1+value2);
//        System.out.println("value1-value2："+value1-value2);
    }
    public int[] MySort (int[] arr) {
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    arr[j] += arr[j+1];
                    arr[j+1] = arr[j] - arr[j+1];
                    arr[j] -= arr[j+1];
                }
            }
        }
        return arr;
    }
}
