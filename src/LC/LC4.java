package LC;

class ListNode {
    int val;
    ListNode next = null;
}


// 排除快排 快排要逆向查找 这是个单向链表
// 堆排基于数组……也不怎么适合这个
// 基于数组的归并要额外的内存空间 但链表不需要
// 升序

public class LC4 {
    /**
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode sortList(ListNode head) {
        if(head==null){
            return null;
        }
        return mergeSort(head);
    }

    static ListNode mergeSort(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode mid = head;
        ListNode end = head;
        while (end.next != null) {
            if (end.next != null) {
                end = end.next;
                if (end.next != null) {
                    end = end.next;
                    mid = mid.next;
                }
            }
        }
        end = mid.next;
        mid.next = null;
        ListNode listNode1 = mergeSort(head);
        ListNode listNode2 = mergeSort(end);
        ListNode resultHead = new ListNode();
        ListNode temp = resultHead;
        while (listNode1 != null || listNode2 != null) {
            if (listNode2 == null) {
                resultHead.next = listNode1;
                resultHead = resultHead.next;
                listNode1 = listNode1.next;
            } else if (listNode1 == null) {//1为空就一直遍历2
                resultHead.next = listNode2;
                resultHead = resultHead.next;
                listNode2 = listNode2.next;
            } else if (listNode1.val < listNode2.val) {
                resultHead.next = listNode1;
                resultHead = resultHead.next;
                listNode1 = listNode1.next;
            } else {
                resultHead.next = listNode2;
                resultHead = resultHead.next;
                listNode2 = listNode2.next;
            }
        }
        return temp.next;
    }

    public static void main(String[] args) {
        LC4 lc4 = new LC4();
        ListNode head = new ListNode();
        ListNode next;
        ListNode now = head;
        head.val = 20;
        for (int i = 0; i < 1; i++) {
            next = new ListNode();
            next.val = (int) (Math.random() * 100);
            now.next = next;
            now = now.next;
        }
        head = mergeSort(head);
        System.out.println();
    }
}
