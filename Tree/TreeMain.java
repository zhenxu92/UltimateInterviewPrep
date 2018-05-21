/**
This class builds a tree and maintain it. It is a program to use other
encapsulated class to test them.

It takes in a string in a format which indicates the node and its value
from root to leaves, from left subtree to right subtree. It uses N to 
indicate that node is null. Each node is has a space in between to separate
them.
*/
import java.util.*;
public class TreeMain {
    public static void main(String args[]) {
        Codec c = new Codec();
        String tree = "3 5 1 6 2 0 8 N N 7 4";
        TreeNode root = c.deserialize(tree);
        // visualize
        c.visualize(root);
        TreeMain t = new TreeMain();
        
        t.writeTree(root);
        System.out.println("\n" + "Preorder:");
        t.loopPreTraversal(root);
        System.out.println("\n" + "Inorder:");
        t.loopInTraversal(root);
        // Successfully completed @8:45 ET 07/18/17
        TreeNode p = new TreeNode(0);
        TreeNode ans = t.findLowestCommonAncestor(root, null, p);
        if (ans != null) System.out.println(ans.val);
        if (ans == null) System.out.println("null");
    }
    
    // writeTree
    // writes the tree in preorder in a form:
    // 3 7
    // 1 9
    // 0 5
    // 3 8
    // 2 4
    // 0 9
    // 0 6
    // where 0 - leaf node
    //       1 branch node with left child only
    //       2 branch node with right child only
    //       3 branch node with nonempty left and right children
    public void writeTree(TreeNode root) {
        writeTreeHelper(root);
    }
    
    private void writeTreeHelper(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            System.out.println("0 " + root.val);
        } else if (root.left == null && root.right != null) {
            System.out.println("2 " + root.val);
        } else if (root.left != null && root.right == null) {
            System.out.println("1 " + root.val);
        } else {
            System.out.println("3 " + root.val);
        }
        writeTree(root.left);
        writeTree(root.right);
    }
    
    // loop traversals
    // The following three methods are using loop to do three
    // different traversals.
    //
    // use while loop to do preorder traversal
    public void loopPreTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            
            if (node.left != null) {
                stack.push(node.left);
            }
        }        
    }
    
    // use while loop to do inorder traversal
    public void loopInTraversal(TreeNode root) {
        // do left
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
    }
    
    // use loop to do postorder traversal
    public void loopPostTraversal(TreeNode root) {
        
    }
    
    // find lowest common ancester
    public TreeNode findLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = findLowestCommonAncestor(root.left, p, q);
        TreeNode right = findLowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
    
    
}