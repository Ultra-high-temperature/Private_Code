package LC;




public class LC8 {

    static class ListNode {
        int val;
        LC8.ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public void reorderList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null){
            return;
        }

        ListNode now = head;
        ListNode next = head.next;
        ListNode t=now;
        while (next!=null&&next.next!=null){
            while (t.next.next!=null){
                t=t.next;//找到当前链表的倒数第二个节点，以便操作最后一个节点
            }
            now.next=t.next;//指向最后一个节点
            t.next.next=next;//将最后一个节点指向next节点
            t.next=null;//断开倒数第二个节点与最后一个节点

            now=next;
            next=next.next;
            t=now;
        }
    }

    public static void main(String[] args) {
        LC8 lc8 = new LC8();
        ListNode head = new ListNode(0);
        ListNode now = head;
        for (int i = 1; i < 10; i++) {
            now.next=new ListNode(i);
            now=now.next;
        }
        lc8.reorderList(head);
        System.out.println();
    }
}
