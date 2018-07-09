/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SubtreeWithAllDeepest {
    static TreeNode res = null;
    
    public static void main(String args[]) {
        Codec c = new Codec();
        TreeNode root = c.deserialize("0 3 1 4 N 2 N N 6 N N N 5 N N N N N N");
        
    }
    
    public static TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        int max = maxDepth(root);
        System.out.println(max);
        helper(root, max);
        return res;
    }
    
    private static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    
    private static boolean helper(TreeNode root, int max) {
        if (root == null) return true;
        if (max == 1) return true;
        boolean left = helper(root.left, max - 1);
        boolean right = helper(root.right, max - 1);
        System.out.println(root.val + " " + left + " " + right);
        if (left && right) {
            res = root;
        }
        return false;
    }
}