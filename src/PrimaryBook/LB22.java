package PrimaryBook;

import java.util.ArrayList;

public class LB22 {
    public ListNode removeNthFromEnd0(ListNode head, int n) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode ptr = head;
        while (ptr!=null){
            list.add(ptr);
            ptr=ptr.next;
        }
        int size = list.size();
        int now = size-n;

        if(size==1&&n==1){
            return null;
        }

        ListNode node = list.get(now);
        if(node.next!=null){
            node.val = node.next.val;
            node.next = node.next.next;
        }else {
            ListNode listNode = list.get(now - 1);
            listNode.next = null;
        }

        return head;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast= fast.next;
        }

        //如果fast为空，表示删除的是头结点
        if (fast == null)
            return head.next;

        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next= slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode ptr = listNode;
        for (int i = 1; i < 5; i++) {
            ptr.next = new ListNode(i);
            ptr=ptr.next;
        }
        LB22 lb22 = new LB22();
        ListNode listNode1 = lb22.removeNthFromEnd(listNode, 1);
        System.out.printf("");
    }
}
