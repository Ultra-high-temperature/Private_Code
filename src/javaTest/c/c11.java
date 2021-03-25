package javaTest.c;


import LC.LC10;

import java.util.ArrayList;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class c11 {
    public ListNode ReverseList(ListNode head) {
        if(head == null){
            return null;
        }
        Stack<ListNode> listNodes = new Stack<>();
        ListNode ptr = head;
        while (ptr!=null){
            listNodes.push(ptr);
            ptr = ptr.next;
        }
        ListNode newHead = listNodes.pop();
        ptr = newHead;
        while (!listNodes.empty()){
            ptr.next = listNodes.pop();
            ptr = ptr.next;
        }
        ptr.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode now = head;
        ListNode t = new ListNode(99);
        now.next = t;
        now = now.next;
        now.next = new ListNode(89);
        now = now.next;

        c11 c11 = new c11();
        ListNode listNode = c11.ReverseList(head);
        return;
    }
}
