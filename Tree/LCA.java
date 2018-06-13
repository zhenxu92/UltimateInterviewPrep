/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LCA {
    public static TreeNode res = null;
    public static void main(String args[]) {
        Codec c = new Codec();
        TreeNode root = c.deserialize("3 5 1 6 2 0 8 N N 7 4 N N N N");
        System.out.println(c.serialize(root));
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);
        System.out.println(lowestCommonAncestor(root, p, q));
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return res;
    }
    
    private static boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        if (root.val == p.val || root.val == q.val) return true;
        boolean left = helper(root.left, p, q);
        boolean right = helper(root.right, p, q);
        if (left && right) {
            res = root;
        }
        if (left || right) return true;
        return false;
    }
}