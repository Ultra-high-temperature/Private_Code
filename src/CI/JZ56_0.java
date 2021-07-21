package CI;

public class JZ56_0 {
    //自己改版
    // 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
    // 重复的结点保留一个，返回链表头指针。
    // 例如，链表1->2->3->3->4->4->5 处理后为 1->2->3->4->5
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null||pHead.next==null) return pHead;
        ListNode now = pHead;
        ListNode next = pHead.next;
        while (next!=null){
            if (now.val == next.val){
                now.next = next.next;
                if(next.next==null){
                    return pHead;
                }
                next = next.next;
            }else {
                now = next;
                next = next.next;
            }
        }
        return pHead;
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
        JZ56_0 jz56 = new JZ56_0();
        jz56.deleteDuplication(l1);
    }
}
