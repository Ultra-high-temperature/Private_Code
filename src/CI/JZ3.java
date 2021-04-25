package CI;


import java.util.ArrayList;
import java.util.Stack;

//https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035
public class JZ3 {
    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> integers = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (listNode != null) {
            integers.push(listNode.val);
            listNode = listNode.next;
        }
        while (!integers.empty()){
            arrayList.add(integers.pop());
        }
        return arrayList;
    }
}
