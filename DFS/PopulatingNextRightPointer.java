public class PopulatingNextRightPointer {
    public TreeLinkNode root;
    
    public PopulatingNextRightPointer (TreeLinkNode root) {
        this.root = root;
    }
    
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        
        TreeLinkNode cur = root;
        TreeLinkNode prev = null;
        TreeLinkNode head = null;
        
        while (cur != null) {
            while (cur != null) {
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                
                cur = cur.next;
            }
            
            cur = head;
            head = null;
            prev = null;
        }
    }
    
    public static void main (String args[]) {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);
        PopulatingNextRightPointerFull p = new PopulatingNextRightPointerFull(root);
        p.connect(p.root);
    }
}