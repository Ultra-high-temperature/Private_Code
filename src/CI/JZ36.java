package CI;

public class JZ36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int num1 = 0;
        int num2 = 0;
        ListNode ptr1=pHead1;
        ListNode ptr2=pHead2;
        while (ptr1!=null){
            ptr1 = ptr1.next;
            num1++;
        }
        while (ptr2!=null){
            ptr2 = ptr2.next;
            num2++;
        }
        if(num1>num2){
            num1 -=num2;
            num2 =0;
        }else {
            num2 -=num1;
            num1 =0;
        }
         ptr1=pHead1;
         ptr2=pHead2;
        if(num1>0){
            for (int i = 0; i < num1; i++) {
                ptr1 = ptr1.next;
            }
        }else {
            for (int i = 0; i < num2; i++) {
                ptr2 = ptr2.next;
            }
        }
        while (ptr1!=ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }

    public static void main(String[] args) {
        JZ36 jz36 = new JZ36();
        ListNode head = new ListNode(0);
        ListNode now = head;
        for (int i = 1; i < 5; i++) {
            now.next = new ListNode(i);
            now = now.next;
        }

        ListNode head2 = new ListNode(0);
        ListNode now2 = head2;
        for (int i = 3; i < 10; i++) {
            now2.next = new ListNode(i);
            now2 = now2.next;
        }

        ListNode common = new ListNode(10);
        ListNode node2 = new ListNode(11);
        now.next = common;
        now2.next = common;
        common.next = node2;

        ListNode listNode = jz36.FindFirstCommonNode(head, head2);
    }
}
