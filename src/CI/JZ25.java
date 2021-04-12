package CI;

import java.util.HashMap;

//https://www.nowcoder.com/practice/f836b2c43afc4b35ad6adc41ec941dba
public class JZ25 {
    //map法 需要额外空间，
    public RandomListNode Clone(RandomListNode pHead) {
        //原链表 引用:索引   新链表 索引:引用
        HashMap<RandomListNode, Integer> oldList = new HashMap<>();
        HashMap<Integer, RandomListNode> newList = new HashMap<>();

        RandomListNode tempHead = new RandomListNode(-1);
        RandomListNode oldPtr = pHead;
        RandomListNode ptr = tempHead;
        int index = 0;

        //构建基础链表
        while (oldPtr!=null){
            RandomListNode node = new RandomListNode(oldPtr.label);

            oldList.put(oldPtr,index);
            newList.put(index,node);

            ptr.next = node;
            ptr = ptr.next;

            oldPtr = oldPtr.next;
            index++;
        }

        //处理随机指针
        oldPtr = pHead;
        while (oldPtr!=null){
            if(oldPtr.random!=null){
                Integer start = oldList.get(oldPtr);
                Integer to = oldList.get(oldPtr.random);

                RandomListNode s1 = newList.get(start);
                RandomListNode s2 = newList.get(to);

                s1.random = s2;
            }
            oldPtr = oldPtr.next;
        }
        return tempHead.next;
    }

    //拆分链表法 无需额外空间
//    public RandomListNode Clone(RandomListNode pHead) {
//        //初次构建子链表
//        RandomListNode ptr = pHead;
//        while (ptr!=null){
//            RandomListNode node = new RandomListNode(ptr.label);
//            node.next = ptr.next;
//        }
//    }

        public static void main(String[] args) {
        JZ25 jz25 = new JZ25();
        RandomListNode head = new RandomListNode(0);
        RandomListNode now = head;
        for (int i = 1; i < 5; i++) {
            now.next = new RandomListNode(i);
            now = now.next;
        }
        head.random = now;

        RandomListNode clone = jz25.Clone(head);
        System.out.println();
    }
}
