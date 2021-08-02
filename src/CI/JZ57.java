package CI;

public class JZ57 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return pNode;
        TreeLinkNode node = pNode;
        while (node.next != null && (node.right == null || node.next.right == node)) {
            node = node.next;
        }
        if (node.next == null) {
            return null;
        }

        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        TreeLinkNode t = new TreeLinkNode(1);
        TreeLinkNode t2 = new TreeLinkNode(2);
        TreeLinkNode t3 = new TreeLinkNode(3);
        t2.left = t;
        t2.right = t3;
        JZ57 jz57 = new JZ57();
        jz57.GetNext(t2);
    }
}
