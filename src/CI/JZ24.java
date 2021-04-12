package CI;

import java.util.ArrayList;
import java.util.LinkedList;

//https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca
//输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
public class JZ24 {

    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root==null&&target==0){
            return result;
        }
        searchRecursion(root,target,new ArrayList<>());
        return result;
    }

    //栈法
    public void searchStack(TreeNode root, int target){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> history = new LinkedList<>();

        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            target -= pop.val;
            history.addLast(pop.val);
            if(pop.left==null&&pop.right==null){
                if(target==0){
                    result.add(new ArrayList<>(history));
                }
            }
        }
    }

    //递归法
    public void searchRecursion(TreeNode root, int num, ArrayList<Integer> list) {

        int newNum = num - root.val;
        list.add(root.val);

        //叶子节点递归出口
        if (root.right==null&&root.left==null) {
            if (newNum == 0) {
                result.add(list);
            }
            return;
        }

        if(root.left!=null){
            searchRecursion(root.left, newNum, new ArrayList<>(list));
        }
        if(root.right!=null){
            searchRecursion(root.right, newNum, new ArrayList<>(list));
        }
    }
}
