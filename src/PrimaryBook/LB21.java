package PrimaryBook;

import java.util.List;

public class LB21 {
    //删除当前节点的
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
