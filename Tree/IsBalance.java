public class IsBalance {
    private static boolean isBal = true;
    public static void main(String args[]) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(4);
        isBalance(root);
        System.out.println(isBal);
    }
    /*
     * check if a binary tree is balanced or not 
     * @param root, root of the binary tree 
     * @return true if the tree is balanced, false
     * otherwise
     */
    private static int isBalance(TreeNode root) {
        if (root == null) return 0;
        int left = isBalance(root.left);
        int right = isBalance(root.right);
        
        if (Math.abs(left - right) >= 1) {
            isBal = false;
        }
        
        return 1 + Math.max(left, right);
    }
}