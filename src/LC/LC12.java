package LC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LC12 {

    static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) {
            this.label = x;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {

        if(head==null||head.next==null){
            return head;
        }
        HashMap<Integer , Integer> nowAndRandom = new HashMap<>();
        ArrayList<RandomListNode> randomListNodes = new ArrayList<>();

        // 加一个头节点，
        RandomListNode tempHead = new RandomListNode(10086);
        tempHead.next=head;
        RandomListNode move = tempHead.next;

        RandomListNode tempCopyHead = new RandomListNode(tempHead.label);
        RandomListNode copyMove = tempCopyHead;

        int i = 0;
        while (move!=null){
            copyMove.next = new RandomListNode(move.label);
            randomListNodes.add(copyMove.next);

            if(move.random!=null){
                RandomListNode s = move.random;
                RandomListNode search = head;

                int j = 0;
                while (search!=s){
                    search = search.next;
                    j++;
                }
                nowAndRandom.put(i,j);
            }
            i++;
            move=move.next;
            copyMove = copyMove.next;
        }

        for(Map.Entry<Integer, Integer> map:nowAndRandom.entrySet()){
            randomListNodes.get(map.getKey()).random = randomListNodes.get(map.getValue());
        }
        return tempCopyHead.next;
    }


    public static void main(String[] args) {
        LC12 lc12 = new LC12();
        RandomListNode head = new RandomListNode(0);
        RandomListNode move = head;
//        for (int i = 1; i < 10; i++) {
//            move.next = new RandomListNode(i);
//            move = move.next;
//        }
        head.random=move;
        RandomListNode randomListNode = lc12.copyRandomList(head);
        System.out.println();
    }
}
