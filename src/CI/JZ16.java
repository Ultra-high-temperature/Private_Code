package CI;

public class JZ16 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode tempHead = new ListNode(-1);
        ListNode ptr = tempHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                ptr.next = list1;
                list1 = list1.next;
            } else {
                ptr.next = list2;
                list2 = list2.next;
            }
            ptr = ptr.next;
        }
        if(list1!=null){
            ptr.next = list1;
        }else if(list2!=null){
            ptr.next = list2;
        }
        return tempHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode now = head;
        for (int i = 1; i < 5; i++) {
            now.next = new ListNode(i);
            now = now.next;
        }

        ListNode head2 = new ListNode(0);
        ListNode now2 = head2;
        for (int i = 3; i < 6; i++) {
            now2.next = new ListNode(i);
            now2 = now2.next;
        }

        JZ16 jz16 = new JZ16();
        ListNode merge = jz16.Merge(head, head2);
        System.out.println();
    }
}
