package CI;

public class JZ17 {
    //在root1中找root2
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root2 == null){
            return false;
        }
        if (root1 == null) {
            return false;
        }
        boolean compare = false;
        if (root1.val == root2.val) {
            compare = compare(root1, root2);
        }
        // 短路运算符，如果compare为true，后续的不会继续计算了
        return compare || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    //在root1中找root2
    public boolean compare(TreeNode root1, TreeNode root2) {
        //当前节点的值
        //判断子节点值
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null && root2 != null) {
            return false;
        }
        if (root1 != null && root2 == null) {
            return true;
        }
        if (root1.val != root2.val) {
            return false;
        }


        return compare(root1.left, root2.left) &&
                compare(root1.right, root2.right);
    }

    public static void main(String[] args) {

    }

}
