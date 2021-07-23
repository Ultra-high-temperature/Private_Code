package CI;

public class JZ56 {
    // 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
    // 重复的结点不保留，返回链表头指针。
    // 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

    @Deprecated
    //愚蠢的方案

    public ListNode deleteDuplication0(ListNode pHead) {

        if(pHead==null){
            return null;
        }

        ListNode tempHead = new ListNode(0);
        tempHead.next = pHead;

        //新链表的末尾
        ListNode a = tempHead;
        //可能会缀到新链表末尾的节点
        ListNode temp = tempHead.next;
        ListNode b = temp.next;

        //标记temp是否能缀到链表末尾
        boolean tempStatus = true;

        while (b != null) {
            if (temp.val == b.val) {
                tempStatus = false;
                b = b.next;
            } else {
                //temp下一个值与之不同
                //2 3 这种情况
                if (tempStatus == true) {
                    a = temp;
                    temp = b;
                    b = b.next;
                } else {
                    //2 2 3的情况
                    a.next = b;
                    temp = b;
                    tempStatus = true;
                    b = b.next;
                }
            }
        }
        if (temp.next == null) {
            return tempHead.next;
        }
        if (temp.next.val == temp.val) {
            a.next = null;
        }
        return tempHead.next;

    }

    //三个指针
    // tail 指向不重复链表的结尾
    // temp 指向待添加的元素
    // next 指向结尾
    public ListNode deleteDuplication1(ListNode pHead) {
        ListNode tempHead = new ListNode(-1);
        tempHead.next = pHead;
        ListNode tail = tempHead;
        ListNode temp = tail.next;
        ListNode next = temp.next;
        while (next!=null){
            if(temp.val!=next.val){
                tail.next = temp;
                tail = tail.next;
                temp = temp.next;
                next = next.next;
            }else {
                while (temp!=null&&temp.val==next.val){
                    temp = temp.next;
                }
                if(temp == null){
                    tail.next = null;
                    return tempHead.next;
                }
                next = temp.next;
            }
        }
        tail.next = temp;
        return tempHead.next;
    }

    //优化版，虽然没什么用
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode temp = new ListNode(-1);
        temp.next = pHead;
        ListNode tail = temp;
        while (pHead!=null){
            if(pHead.next == null||pHead.next.val!=pHead.val){
                tail.next = pHead;
                tail = temp.next;
            }else {
                while (pHead.next!=null&&pHead.next.val==pHead.val){
                    pHead = pHead.next;
                }
            }
            pHead = pHead.next;
        }
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        JZ56 jz56 = new JZ56();
        jz56.deleteDuplication(l1);
    }
}
