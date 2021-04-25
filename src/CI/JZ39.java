package CI;

public class JZ39 {
    //true 尚未发现子树高度差大于1的树
    public boolean flag = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        depthFirst(root,0);
        return flag;
    }

    public int depthFirst(TreeNode node, int value) {
        if (!flag||node == null) {
            return value;
        }
        value++;
        int l = depthFirst(node.left, value);
        int r = depthFirst(node.right, value);
        if(Math.abs(l-r)>1){
            flag = false;
        }
        return l > r ? l : r;
    }
}
