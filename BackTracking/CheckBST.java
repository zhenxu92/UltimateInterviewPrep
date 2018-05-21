public class CheckBST {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(7);
        isBST(root);
    }
    
    public static boolean isBST(TreeNode root) {
        if (root == null) return false;
        
    }
}