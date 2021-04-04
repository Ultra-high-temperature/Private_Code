package CI;

//https://www.nowcoder.com/practice/886370fe658f41b498d40fb34ae76ff9
//输入一个链表，输出该链表中倒数第k个结点。
//如果该链表长度小于k，请返回空。


import LC.LC9;



public class JZ14 {
    public ListNode FindKthToTailError(ListNode pHead, int k) {
        //快指针先走k-1步（倒数第一个节点 快慢指针相同）
        ListNode fastPtr = pHead;
        for (int i = 1; i < k; i++) {
            if(fastPtr!=null){
                fastPtr = fastPtr.next;
            }else {
                return null;
            }
        }
        while (fastPtr.next!=null){
            fastPtr = fastPtr.next;
            pHead = pHead.next;
        }
        return pHead;
    }

    public ListNode FindKthToTail(ListNode pHead, int k) {
        //快指针先走k步
        ListNode fastPtr = pHead;
        for (int i = 0; i < k; i++) {
            if(fastPtr!=null){
                fastPtr = fastPtr.next;
            }else {
                return null;
            }
        }
        while (fastPtr!=null){
            fastPtr = fastPtr.next;
            pHead = pHead.next;
        }
        return pHead;
    }
    public static void main(String[] args) {

        ListNode head = new ListNode(0);
        ListNode now = head;
        for (int i = 1; i < 5; i++) {
            now.next = new ListNode(i);
            now = now.next;
        }

        JZ14 jz14 = new JZ14();
        ListNode listNode = jz14.FindKthToTail(head, 6);
        System.out.println();
    }
}
