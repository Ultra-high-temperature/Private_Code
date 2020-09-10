package LC;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class LC7 {

    // 先序遍历 根左右
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            TreeNode pop = stack.pop();

            System.out.println(pop.val);
            result.add(pop.val);

            if (pop.right != null) {
                stack.add(pop.right);
            }
            if (pop.left != null) {
                stack.add(pop.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(treeNode);
        for (int i = 1; i < 6; i++) {
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

        LC7 lc7 = new LC7();
        ArrayList<Integer> integers = lc7.preorderTraversal(treeNode);
        System.out.println(integers);
    }

}
