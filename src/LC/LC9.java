package LC;

import java.util.HashMap;
import java.util.HashSet;

public class LC9 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<ListNode>();

        while (head!=null){
            if(hashSet.contains(head)){//判断节点是否已经出现在 hashSet中 直到找到第一个出现的
                return head;
            }else { // 不存在则加入
                hashSet.add(head);
            }
            head=head.next;
        }
        return null;
    }



    public static void main(String[] args) {
        LC9 lc9 = new LC9();
        ListNode head = new ListNode(0);
        ListNode now = head;

        ListNode t = new ListNode(99);
        now.next = t;
        now = now.next;
        now.next = new ListNode(89);
        now = now.next;

        for (int i = 1; i < 10; i++) {
            now.next = new ListNode(i);
            now = now.next;
        }

        now.next=t;

        ListNode listNode = lc9.detectCycle(head);
        System.out.println();

    }

}
