package javaTest.c;


import java.util.HashSet;

public class c4 {


    private static class ListNode {
        int val;
        ListNode next = null;
    }

    /**
     * @param l1 ListNode类
     * @param l2 ListNode类
     * @return ListNode类
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int addNext=0;
        int l1num=0;
        int l2num=0;

        ListNode head=new ListNode();
        ListNode end=head;

        while (l1!=null||l2!=null||addNext!=0){

            int val=0;
            if(l1==null){
                l1num=0;
            }else {
                l1num=l1.val;
            }
            if(l2==null){
                l2num=0;
            }else {
                l2num=l2.val;
            }

            if(l1num+l2num+addNext>=10){
                val=l1num+l2num+addNext-10;
                addNext=1;
            }else {
                val=l1num+l2num+addNext;
                addNext=0;
            }

            if(l1==null){
                l1=null;
            }else {
                l1=l1.next;
            }
            if(l2==null){
                l2=null;
            }else {
                l2=l2.next;
            }

            ListNode nextNode=new ListNode();
            nextNode.val=val;
            end.next=nextNode;
            end=end.next;
        }
        return head.next;
    }


    public static void main(String[] args) {
        ListNode listNode1=new ListNode();
        listNode1.val=3;
        ListNode listNode2=new ListNode();
        listNode2.val=9;
        new c4().addTwoNumbers(listNode1,listNode2);
    }

}
