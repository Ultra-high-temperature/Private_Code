package CI;

public class JZ58 {
    //判断一棵二叉树是不是对称的。
    // 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot==null){
            return true;
        }
        boolean check = check(pRoot.left, pRoot.right);
        return check;
    }
    boolean check(TreeNode l,TreeNode r){
        if(l==r&&l==null){
            return true;
        }
        if(l!=null&&r!=null&&l.val==r.val){
            if(check(l.left,r.right)&&check(l.right,r.left)){
                return true;
            }
        }
        return false;
    }
}
