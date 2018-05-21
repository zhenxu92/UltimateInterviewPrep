public class BSTPresent {
    public static boolean exist = false;
    public static void main(String args[]) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(7);
        System.out.println(isPresent(root, 7));
    }
    
    public static int isPresent(TreeNode root, int val) {
        if (root == null) return 0;
        if (root.val == val) return 1;
        helper(root, val);
        if (exist) {
            return 1;
        } else {
            return 0;
        }
    }
    
    private static void helper(TreeNode root, int val) {
        if (root == null) return;
        if (root.val == val) exist = true;
        if (root.val > val) {
            helper(root.left, val);
        } else {
            helper(root.right, val);
        }
        
    }
    

}