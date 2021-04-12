package CI;

import java.util.LinkedList;

public class JZ20 {

    private LinkedList<Integer> stack = new LinkedList();
    private LinkedList<Integer> minStack = new LinkedList();

    public void push(int node) {
        stack.push(node);
        if(minStack.isEmpty()||minStack.peek()>=node){
            minStack.push(node);
        }
    }

    public void pop() {
        Integer pop = stack.pop();
        if(minStack.peek() == pop){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        JZ20 stack = new JZ20();
        stack.push(2);
        stack.push(5);
        stack.push(1);
        stack.push(6);
        stack.push(1);
        stack.pop();
        int min = stack.min();
        System.out.println(min);
    }
}
