package LC;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
}

public class LC6 {


    // 后续遍历 左右根
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            TreeNode pop = stack.pop();
            if (pop.right == null && pop.left == null) {
                System.out.println(pop.val);

                result.add(pop.val);
            } else {
                stack.add(pop);//还有价值，不能抛出
                if (pop.right != null) {
                    stack.add(pop.right);
                }
                if (pop.left != null) {
                    stack.add(pop.left);
                }
                pop.right = null;
                pop.left = null;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(treeNode);
        for (int i = 1; i < 2; i++) {
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

        LC6 lc6 = new LC6();
        ArrayList<Integer> integers = lc6.postorderTraversal(treeNode);
        System.out.println(integers);
    }

}
