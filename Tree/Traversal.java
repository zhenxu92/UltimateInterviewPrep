// Traversal v 1.0
// @author zhen xu
// 05/09/2017
// This class is a generic traversal which visit every node and print
// out its value.
public class Traversal {
    public static void main(String args[]) {
        // create a tree with a depth of 2
        IntTreeNode root = new IntTreeNode(0, new IntTreeNode(1), new IntTreeNode(2));
        root.left.left = new IntTreeNode(3);
        root.left.right = new IntTreeNode(4);
        root.left.left.left = new IntTreeNode(5);
        root.right.right = new IntTreeNode(6);
        root.left.left.right = new IntTreeNode(7);
        root.right.left = new IntTreeNode(8);
        // In my traversal, I visited the leaf nodes from left to root to right
        traverse(root);
    }
    
    public static void traverse(IntTreeNode root) {
        if (root == null)  {
            System.out.print(' ');
        } else {
            // The core of tree traversal order is here
            // By changing the order of these three lines of codes
            // we can have three different traversal orders
            // First: whenever there is a root, go left to find if it has any child
            // if so, keep going, then show left to node to right
            // Second, show left right and node
            // Third, show root, left right
            traverse(root.left);

            System.out.print( root.val );

            traverse(root.right);


        }
    }

}