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
        TreeNode res = lowestCommonAncestor(root, p, q);
        if (res != null) {  
            System.out.println(res.val);
        } else {
            System.out.println("no such node");
        }
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        if (left == null) {
            return right;
        } else {
            return left;
        }
    }
    
}