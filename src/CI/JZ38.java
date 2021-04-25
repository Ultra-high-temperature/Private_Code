package CI;

public class JZ38 {
    public int TreeDepth(TreeNode root) {
        return depthFirst(root, 0);
    }

    public int depthFirst(TreeNode node, int value) {
        if (node == null) {
            return value;
        }
        value++;
        int l = depthFirst(node.left, value);
        int r = depthFirst(node.right, value);
        return l > r ? l : r;
    }

    public static void main(String[] args) {
        JZ38 jz38 = new JZ38();
//        jz38.TreeDepth();
    }
}
