package CI;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//https://www.nowcoder.com/practice/7fe2212963db4790b57431d9ed259701
//二叉树层序遍历
public class JZ22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node!=null){
                queue.add(node.left);
                queue.add(node.right);
                arrayList.add(node.val);
            }
        }
        return arrayList;
    }
}
