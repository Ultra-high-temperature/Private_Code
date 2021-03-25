package LC;

import java.util.HashSet;

public class LC10 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null&&fast.next!=null){
            if(fast==slow){
                return true;
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        return false;
    }

    

    public static void main(String[] args) {
        LC10 lclc10 = new LC10();
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

        boolean b = lclc10.hasCycle(head);
        System.out.println();

    }

}
