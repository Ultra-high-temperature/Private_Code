package OrtherCode;

public class RoundTest {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if(head ==null){
            return false;
        }
        ListNode a = head;
        ListNode a2 = head;
        while (true){
            a = a.next;
            if(a2!=null&&a2.next!=null){
                a2 = a2.next.next;
            }else {
                return false;
            }
            if(a2 == a){
                return true;
            }
        }
    }

    public static void main(String[] args) {

    }
}
