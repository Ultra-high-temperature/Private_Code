package OrtherCode;

/*
将给出的链表中的节点每 k 个一组翻转，返回翻转后的链表
如果链表中的节点数不是 k 的倍数，将最后剩下的节点保持原样
你不能更改节点中的值，只能更改节点本身。
要求空间复杂度  O(1)
例如：
给定的链表是1→2→3→4→5
对于 k=2, 你应该返回 2→1→4→3→5
对于 k=3, 你应该返回 3→2→1→4→5
 */
public class InversionListNode {

    public static class ListNode {
        int val;
        ListNode next = null;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null){
            return null;
        }
        if( k ==1){
            return head;
        }
        int size = 1;
        ListNode s = head;
        while (s.next!=null){
            size++;
            s = s.next;
        }

        //一个虚拟的头节点
        ListNode head0 = new ListNode();
        head0.next = head;
        //找到需要翻转的节点数量
        int len = size - size%k;
        ListNode ptr = head0;

        for (int i = 0; i<len; i++,ptr = ptr.next) {
            if(i%k == 0){
                reverse(ptr,k);
            }
        }
        return head0.next;
    }

    // 翻转的实际执行类 head是实际需要反转的前一个节点 end是实际需要反转的最后一个节点+1
    // 反转123    head→ 1→ 2→ 3→ end
    void reverse(ListNode head, int k){
        ListNode end = head;
        for (int i = 0; i <= k; i++) {
            end = end.next;
        }
        ListNode a = head;
        ListNode now = a.next;
        ListNode b = now.next;
        for (int i = 0; i < k; i++) {
            now.next = a;
            a = now;
            now = b;
            b = b.next;
            if(b == null){
                break;
            }
        }
        head.next.next = now;
        head.next = a;
//        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head0 = new ListNode();
        ListNode ptr = head0;
        for (int i = 1; i <=5; i++) {
            ptr.next = new ListNode();
            ptr.next.val = i;
            ptr = ptr.next;
        }
        InversionListNode inversionListNode = new InversionListNode();
        ListNode listNode = inversionListNode.reverseKGroup(head0.next, 2);
        System.out.println();
    }
}
