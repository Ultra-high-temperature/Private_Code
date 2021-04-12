package CI;

import java.util.LinkedList;

//https://www.nowcoder.com/practice/a9d0ecbacef9410ca97463e4a5c83be7
//二叉树镜像
public class JZ18 {
    //递归解法
    public TreeNode Mirror1(TreeNode pRoot) {
        swap(pRoot);
        return pRoot;
    }

    //栈解法
    public TreeNode Mirror(TreeNode pRoot) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.push(pRoot);
        while (!list.isEmpty()){
            TreeNode node = list.pop();
            if(node!=null){
                list.push(node.left);
                list.push(node.right);
            }
            swap2(node);
        }
        return pRoot;
    }

    public void swap2(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
    }

    public void swap(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        swap(root.left);
        swap(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(6);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;

        JZ18 jz18 = new JZ18();
        TreeNode mirror = jz18.Mirror(treeNode);
        System.out.println();
    }
}
