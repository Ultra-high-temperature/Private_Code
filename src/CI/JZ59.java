package CI;

import java.util.ArrayList;

public class JZ59 {
    //给定一个二叉树，返回该二叉树的之字形层序遍历，
    // （第一层从左向右，下一层从右向左，一直这样交替）
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList> result = new ArrayList<>();
        ArrayList<TreeNode> lTor = new ArrayList<>();
        ArrayList<TreeNode> rTol = new ArrayList<>();
        ArrayList<Integer> list= new ArrayList<>();

        //标记当前层的遍历顺序，true为左到右边
        boolean flag = false;
        rTol.add(pRoot);

        while (lTor.size() != 0 || rTol.size() != 0) {
            //左向右
            if (flag == true) {

            } else {
                //右向左
                for (TreeNode node :
                        rTol) {
                    if (node.left != null){
                        lTor.add(node.left);
                    }
                    if (node.right != null){
                        lTor.add(node.right);
                    }
                }

            }

        }


    }

    ArrayList<Integer> reverse() {

    }

}
