package CI;

import java.util.Stack;

//https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6
public class JZ5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    // 入队列 直接add到栈1就行了
    public void push(int node) {
        stack1.push(node);
    }

    // 出队列 将栈1元素挪到栈2 取出栈2 顶元素
    public int pop() {
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int result = stack2.pop();
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        JZ5 jz4 = new JZ5();
        jz4.push(0);
        jz4.push(1);
        jz4.push(2);
        System.out.println(jz4.pop());
        System.out.println(jz4.pop());
        System.out.println(jz4.pop());
        System.out.println(jz4.pop());
    }
}
