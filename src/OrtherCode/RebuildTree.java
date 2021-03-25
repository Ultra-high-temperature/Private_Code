package OrtherCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/*
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
*/
public class RebuildTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length==0){
            return null;
        }
        List<Integer> ints = Arrays.stream(pre).boxed().collect(Collectors.toList());
        LinkedList<Integer> preList = new LinkedList<>(ints);
        TreeNode treeNode = buildTree(preList, in, preList.pop(), 0, in.length - 1);
        return treeNode;
    }

    //根节点的值 和该子树在中序遍历数组中的范围
    public TreeNode buildTree(LinkedList<Integer> preList,int[] in,Integer rootNodeValue,Integer inStart,Integer inEnd){

        TreeNode rootNode = new TreeNode(rootNodeValue);
        Integer rootNodeIndex = searchIndexByValue(in, rootNodeValue);

        if(inStart<=rootNodeIndex-1){
            rootNode.left = buildTree(preList,in,preList.pop(),inStart,rootNodeIndex-1);
        }else {
            rootNode.left = null;
        }
        if(rootNodeIndex+1<=inEnd){
            rootNode.right = buildTree(preList,in,preList.pop(),rootNodeIndex+1,inEnd);
        }else {
            rootNode.right = null;
        }
        return rootNode;
    }

    public Integer searchIndexByValue(int[] in,Integer rootNodeValue){
        for (int i = 0; i < in.length; i++) {
            if(in[i] == rootNodeValue){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RebuildTree rebuildTree = new RebuildTree();
        TreeNode treeNode = rebuildTree.reConstructBinaryTree(new int[]{}, new int[]{});
//        TreeNode treeNode = rebuildTree.reConstructBinaryTree(new int[]{1,2,3,4,5,6,7}, new int[]{3,2,4,1,6,5,7});
        System.out.println();
    }

}
