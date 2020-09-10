package LC;

import java.util.Arrays;
import java.util.Stack;

public class LC5 {

    // 升序
    public ListNode insertionSortList(ListNode head) {

        if (head == null) {
            return null;
        }
        // 暂存待插入节点
        ListNode temp = head.next;
        // 保存待插入位置的前后节点
        ListNode now = head;
        ListNode next = head.next;
        // 有序区结尾指针
        ListNode end = head;
        while (end.next != null) {

            if (temp.val > end.val) {//直接放在末尾，不用取出来了
                end = end.next;
                temp = end.next;
                continue;
            } else if (temp.val < head.val) {//插入首位
                end = end.next.next;
                temp.next = head;
                head = temp;
                continue;
            }
            end = end.next.next;//跳过temp所指向的节点
            while (true) {
                if (temp.val < next.val) {
                    now.next = temp;
                    temp.next = next;
                    break;
                }
                now = now.next;
                next = next.next;
            }
            now = head;
            next = head.next;
            temp = end.next;
        }
        return head;
    }

    public ListNode insertionSortList2(ListNode head) {
        if (head == null) {
            return null;
        }
        // 暂存待插入节点
        ListNode temp = head.next;
        // 保存待插入位置的前后节点
        ListNode now = head;
        ListNode next = head.next;
        // 有序区结尾指针
        ListNode end = head;

        while (end.next != null) {
            if (temp.val >= end.val) {//判断temp是否应该放在尾部
                end = end.next;
                temp = temp.next;
                continue;
            }
            if (temp.val < head.val) {//判断temp是否应该放在头部
                end.next = end.next.next;
                temp.next = head;
                head = temp;
                temp = end.next;
                continue;
            }
            end.next = end.next.next;
            now = head;
            next = head.next;
            while (true) {
                if (temp.val <= next.val) {
                    now.next = temp;
                    temp.next = next;
                    break;
                }
                now = now.next;
                next = next.next;
            }
            temp = end.next;
//            now = head;
//            next = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.addAll(Arrays.asList(3, 1, 2));

        LC5 lc5 = new LC5();
        ListNode head = new ListNode();
        ListNode next;
        ListNode now = head;
        head.val = 4;

        for (int i = 0; i < 3; i++) {
            next = new ListNode();
//            next.val = (int) (Math.random() * 100);
            next.val = (int) (stack.pop());

            System.out.println(next.val + "  ");
            now.next = next;
            now = now.next;
        }

        lc5.insertionSortList2(head);
        System.out.println();
    }
}
