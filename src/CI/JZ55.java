package CI;

public class JZ55 {
    //描述
    //给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，返回null。
    //
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead.next == null || pHead.next.next == null) {
            return null;
        }
        //快慢指针法
        ListNode fastPtr = pHead.next.next;
        ListNode slowPtr = pHead.next;
        while (fastPtr != slowPtr) {
            if (fastPtr.next == null || fastPtr.next.next == null) {
                return null;
            }
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }

        slowPtr = pHead;
        while (fastPtr != slowPtr) {
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
        }

        return fastPtr;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l3;

        JZ55 jz55 = new JZ55();
        jz55.EntryNodeOfLoop(l1);

    }
}
