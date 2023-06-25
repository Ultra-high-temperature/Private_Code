package PrimaryBook;

public class LB23 {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode tempHead = new ListNode(-1);
        while (head!=null){
            ListNode temp  = head.next;
            head.next = tempHead.next;
            tempHead.next = head;
            head = temp;
        }
        return tempHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode ptr = listNode;
        for (int i = 1; i < 5; i++) {
            ptr.next = new ListNode(i);
            ptr=ptr.next;
        }
        LB23 lb23 = new LB23();
        ListNode listNode1 = lb23.reverseList(listNode);
        System.out.printf("");
    }
}
