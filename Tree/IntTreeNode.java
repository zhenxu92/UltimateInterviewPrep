// IntTreeNode v 1.0
// @author: zhen xu
// 05/09/2017
// A generic binary tree with integers

public class IntTreeNode {
    // data field
    public int val;    // value of the tree node
    public IntTreeNode left; // left node
    public IntTreeNode right; // right node
    
    // constructors
    // This constructor constructs a tree node with no leaf node
    public IntTreeNode (int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }   
    
    // This constructor constructs a tree node with two leaf nodes
    public IntTreeNode ( int val, IntTreeNode left, IntTreeNode right) {
        this.val = val;
        this.left= left;
        this.right = right;
    }
}