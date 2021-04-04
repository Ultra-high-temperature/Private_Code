package CI;

//链表逆序
public class JZ15 {
    public ListNode ReverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode now = head;
        ListNode a = null;
        ListNode b = head.next;
        while (true){
            now.next = a;

            if(b!=null){
            }else {
                return now;
            }
            a = now;
            now = b;
            b = b.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode now = head;
        for (int i = 1; i < 5; i++) {
            now.next = new ListNode(i);
            now = now.next;
        }
        JZ15 jz15 = new JZ15();
        ListNode listNode = jz15.ReverseList(head);
        System.out.println();
    }
}
