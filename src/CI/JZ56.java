package CI;

public class JZ56 {
    // 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
    // 重复的结点不保留，返回链表头指针。
    // 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
    public ListNode deleteDuplication(ListNode pHead) {
        //新链表的末尾
        ListNode a = pHead;
        //可能会缀到新链表末尾的节点
        ListNode temp = pHead.next;
        ListNode b = temp.next;

        //标记temp是否能缀到链表末尾
        boolean tempStatus = true;

        while (b != null) {
            if (temp.val == b.val) {
                tempStatus = false;
                b = b.next;
            } else {
                //temp下一个值与之不同
                //2 3 这种情况
                if (tempStatus == true) {
                    a = temp;
                    temp = b;
                    b = b.next;
                } else {
                    //2 2 3的情况
                    a.next = b;
                    temp = b;
                    tempStatus = true;
                    b = b.next;
                }
            }
        }
        if(temp.next.val == temp.val){
            a.next = null;
        }
        return pHead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        JZ56 jz56 = new JZ56();
        jz56.deleteDuplication(l1);
    }
}
