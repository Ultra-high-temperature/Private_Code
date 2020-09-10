package test;


public class score {
    Integer a;
    Integer b;

    score(){
        System.out.println("score");
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public Integer test(){
        double i = 10;
        String s = "123";
        System.out.println(s);
        s+=i;
        i=i/(a+1);
        System.out.println(s+i);
        return (int) i;
    }
}
