package CI;

import java.util.Arrays;
import java.util.LinkedList;

public class JZ21 {
    //队列+栈解决问题 a入栈序列 b出栈序列
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        LinkedList<Integer> stack = new LinkedList<>();
        int i = 0;
        int j = 0;
        for (; i < pushA.length; ) {
            if (pushA[i] != popA[j]) {
                if (!stack.isEmpty()&&stack.peek() == popA[j]) {
                    //相同则代表将栈顶元素出栈
                    stack.pop();
                    j++;
                } else {
                    //都不相同则入栈
                    stack.push(pushA[i]);
                    i++;
                }
            } else {
                //相同则代表入栈后立即出栈
                i++;
                j++;
            }
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != popA[j++]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        JZ21 jz21 = new JZ21();
//        boolean b = jz21.IsPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2});
        boolean b2 = jz21.IsPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 2, 1});
        System.out.println();
    }
}
