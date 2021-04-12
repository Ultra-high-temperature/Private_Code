package CI;

import java.util.LinkedList;

public class JZ26 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        LinkedList<TreeNode> list = new LinkedList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode ptr = pRootOfTree;
        while (ptr!=null||!stack.isEmpty()){
            while (ptr!=null){
                stack.push(ptr);
                ptr = ptr.left;
            }
            if (!stack.isEmpty()){
                TreeNode node = stack.pop();
                list.add(node);
                ptr = node.right;
            }
        }

        TreeNode head = list.pollFirst();
        TreeNode listPtr = head;

        while (!list.isEmpty()){
            TreeNode node = list.pollFirst();
            listPtr.right = node;
            node.left = listPtr;
            listPtr = listPtr.right;
        }
        return head;
    }

    public static void main(String[] args) {
        JZ26 jz26 = new JZ26();

        TreeNode treeNode = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(7);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(8);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;

        jz26.Convert(treeNode);
    }
}
