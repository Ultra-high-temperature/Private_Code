package CI;

import java.util.ArrayList;

public class JZ57_0 {
    //给定一个二叉树其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
    //中序 左 根 右边
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode==null) return null;
        TreeLinkNode root = pNode;
        while (root.next!=null){
            root = root.next;
        }
        search(root);
        for (int i = 0; i < list.size(); i++) {
            if(pNode == list.get(i)){
                if(i+1<list.size()){
                    return list.get(i+1);
                }else {
                    return null;
                }
            }
        }
        return null;
    }

    static ArrayList<TreeLinkNode> list = new ArrayList<>();

    private void search(TreeLinkNode root){
        if(root==null){
            return;
        }
        search(root.left);
        list.add(root);
        search(root.right);
    }

    public static void main(String[] args) {
        JZ57_0 jz57 = new JZ57_0();
        TreeLinkNode treeNode = new TreeLinkNode(5);
        TreeLinkNode treeNode1 = new TreeLinkNode(4);
        TreeLinkNode treeNode2 = new TreeLinkNode(7);
        TreeLinkNode treeNode3 = new TreeLinkNode(6);
        TreeLinkNode treeNode4 = new TreeLinkNode(8);
        treeNode1.next = treeNode;
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;

        TreeLinkNode treeLinkNode = jz57.GetNext(treeNode1);
    }
}
