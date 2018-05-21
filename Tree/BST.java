// This is a Binary Search Tree 
//
import java.util.*;
public class BST {
    // data field
    // All I need is a root
    TreeNode root;
    
    // Constructor
    // Takes in an array of integers and build the BST
    public BST(int[] arr) {
    
    }
    
    // find 
    public int find(int val, TreeNode root) {
        // judge if there is an external root
        TreeNode start = null;
        if (root == null) {
            start = this.root;
        } else {
            start = root;
        }
        return findHelper(val, start);
    }
    
    private int findHelper(int val, TreeNode root) {
        if (root == null) {
            throw new IllegalStateException();
        }
        
        if (root.val > val) {
            return findHelper(val, root.left);
        } else if (root.val < val) {
            return findHelper(val, root.right);
        } else {
            return root.data;
        }
    }
    
    // insert
    public void insert(int val, int data) {
    
    }
    
    // build
    public void build(int[] arr) {
    
    }
}