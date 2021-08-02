package CI;

import java.util.ArrayList;
import java.util.Arrays;

public class JZ59 {
    //给定一个二叉树，返回该二叉树的之字形层序遍历，
    // （第一层从左向右，下一层从右向左，一直这样交替）
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if(pRoot==null)return result;

        ArrayList<TreeNode> lTor = new ArrayList<>();
        ArrayList<TreeNode> rTol = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        //标记当前层的遍历顺序，true为左到右边
        boolean flag = true;
        lTor.add(pRoot);

        while (lTor.size() != 0 || rTol.size() != 0) {
            list = new ArrayList<>();
            //左向右
            if (flag == true) {
                for (TreeNode node : lTor) {
                    if (node.left != null) {
                        rTol.add(node.left);
                    }
                    if (node.right != null) {
                        rTol.add(node.right);
                    }
                    list.add(node.val);
                }
                lTor.clear();
            } else {
                //右向左
                for (TreeNode node : rTol) {
                    if (node.left != null) {
                        lTor.add(node.left);
                    }
                    if (node.right != null) {
                        lTor.add(node.right);
                    }
                    list.add(node.val);
                }
                list = reverse(list);
                rTol.clear();
            }
            flag = !flag;
            result.add(list);
        }
        return result;
    }
    static ArrayList<Integer> reverse(ArrayList<Integer> list) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i : list) {
            result.add(0,i);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(7);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(8);

        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(7);
        TreeNode treeNode7 = new TreeNode(6);
        TreeNode treeNode8 = new TreeNode(8);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;

        treeNode3.left = treeNode5;
        treeNode3.right = treeNode6;
        treeNode4.left = treeNode7;
        treeNode4.right = treeNode8;

        JZ59 jz59 = new JZ59();
        ArrayList<ArrayList<Integer>> print = jz59.Print(treeNode);
    }

    public static void main0(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,3,5,7,9,11,13,15));
        ArrayList<Integer> reverse = reverse(list);
        System.out.println();
    }

}
