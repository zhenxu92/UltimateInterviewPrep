import java.util.*;
public class PopulateNextRightPointerII {

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
        TreeLinkNode cur = root;
        TreeLinkNode head = null;
        TreeLinkNode prev = null;
        
    }
}