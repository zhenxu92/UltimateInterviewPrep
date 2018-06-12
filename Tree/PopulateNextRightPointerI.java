import java.util.*;
public class PopulateNextRightPointerI {

    public static void main(String args[]) {
        Codec c = new Codec();
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(1);
        root.right = new TreeLinkNode(1);
        root.left.left = new TreeLinkNode(1);
        root.left.right = new TreeLinkNode(1);
        root.right.right = new TreeLinkNode(1);
        root.right.left = new TreeLinkNode(1);
        connect(root);
    }
    
    public static void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            TreeLinkNode prev = null;
            for (int i = 0; i < size; i++) {
                TreeLinkNode cur = q.remove();
                if (prev == null) prev = cur;
                else {
                    prev.next = cur;
                    prev = cur;
                }
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }

            }
        }
        return;
    }
}