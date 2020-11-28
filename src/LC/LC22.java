package LC;

import java.util.LinkedList;

public class LC22 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }


    /**
     * @param root TreeNode类
     * @return int整型
     */
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        int i = nodeSearch(root, "");
        return i;
    }

    public int nodeSearch(TreeNode node , String s){
        int l = 0 ;
        int r = 0 ;
        if(node.left!=null){
            l = nodeSearch(node.left, s + node.val);
        }
        if(node.right!=null){
            r = nodeSearch(node.right, s + node.val);
        }
        if (node.left==null&&node.right==null){
            Integer integer = Integer.valueOf(s+node.val);
            return integer;
        }
        return l+r;
    }

    public static void main(String[] args) {
        LC22 lc22 = new LC22();

        TreeNode treeNode = new TreeNode();
        treeNode.val = 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(treeNode);
        for (int i = 1; i < 4; i++) {
            TreeNode poll = queue.poll();
            TreeNode l = new TreeNode();
            TreeNode r = new TreeNode();
            poll.left = l;
            poll.right = r;
            queue.offer(l);
            queue.offer(r);
            l.val = i++;
            r.val = i;
        }

        int i = lc22.sumNumbers(treeNode);
        System.out.println(i);
    }
}
