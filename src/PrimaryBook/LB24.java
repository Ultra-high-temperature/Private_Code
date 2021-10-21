package PrimaryBook;

public class LB24 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ptr1 = l1;
        ListNode ptr2= l2;
        ListNode tempH = new ListNode(-1);
        ListNode tempE = tempH;
        while (ptr1!=null&&ptr2!=null){
            if(ptr1.val<ptr2.val){
                tempE.next = ptr1;
                ptr1 = ptr1.next;
            }else {
                tempE.next = ptr2;
                ptr2 = ptr2.next;
            }
            tempE = tempE.next;
        }
        if(ptr1!=null){
            tempE.next = ptr1;
        }else {
            tempE.next = ptr2;
        }
        return tempH.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode ptr = listNode;
        for (int i = 1; i < 5; i++) {
            ptr.next = new ListNode(i);
            ptr=ptr.next;
        }
        ListNode listNode2 = new ListNode(0);
        ptr = listNode2;
        for (int i = 1; i < 5; i++) {
            ptr.next = new ListNode(i);
            ptr=ptr.next;
        }
        LB24 lb24 = new LB24();
        ListNode listNode1 = lb24.mergeTwoLists(listNode2, listNode);
        System.out.printf("");
    }
}
