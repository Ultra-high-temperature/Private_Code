package test;

import java.util.ArrayList;

public class stu {
    
    public stu() {
        System.out.println("stu 被创建");
    }

    public static score score1 = new score();
    
    static {
        System.out.println("静态块");
    }
}
