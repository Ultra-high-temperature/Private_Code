package PrimaryBook;

public class LB25 {
    //将有序数组转换为二叉搜索树 https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xninbt/


    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode node = new TreeNode();
        build(node,0,nums.length-1,nums);
        return node;
    }

    private boolean build(TreeNode fatherNode, int left, int right, int[] nums) {
        if(left>right||left<0||right>=nums.length){
            return false;
        }
        int now = (left + right) / 2;
        fatherNode.val = nums[now];
        fatherNode.left = new TreeNode();
        fatherNode.right = new TreeNode();
        if(build(fatherNode.left,left,now-1,nums)==false){
            fatherNode.left = null;
        }

        if(build(fatherNode.right,now+1,right,nums)==false){
            fatherNode.right = null;
        }
        return true;
    }

    public static void main(String[] args) {
        LB25 lb25 = new LB25();
        TreeNode treeNode = lb25.sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6});
        System.out.printf("");
    }
}
