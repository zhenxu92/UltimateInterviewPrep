// MaxDepth v1.0 05/09/2017
// @author: Zhen Xu
// This class takes in a tree and calculate the maximum depth
// of the tree.
public class MaxDepth {
    public static void main (String args[]) {
        IntTreeNode root = new IntTreeNode(0);
        root.left = new IntTreeNode(1);
        root.right = new IntTreeNode(2);
        root.right.left = new IntTreeNode(3);
        root.left.left = new IntTreeNode(4);
        root.left.left.left = new IntTreeNode(5);
        System.out.println("The max depth is " + depth(root, 0));
        System.out.println("The min depth is " + getDepth(root));
    }
    // @param
    // head: root node of a tree.
    // dep: initial depth dep = 0.'
    // Post: return the depth of the tree
    // Algorithm: every time you find a new child, you add 1 to the dep,
    // when there is no child node, return the dep (in this way, we always
    // touch the leaf node). The Math.max(a, b) 
    // function choose the maximum depth of the tree in that left and right
    // depth might be different.
    public static int depth(IntTreeNode head, int dep) {
        if (head == null) {
            return dep;
        } else {
            return Math.max(depth(head.left, dep + 1), depth(head.right, dep + 1));
        } 
    }
    
    public static int getDepth(IntTreeNode head) {
        if (head == null) return 0;
        return 1 + Math.min(getDepth(head.left), getDepth(head.right));
    }
}