/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
class TwoSumIV {
    private static Set<Integer> set = new HashSet<>();
    static boolean res = false;
    
    public static void main(String args[]) {
        TreeNode root = new TreeNode(0);
        root.right = new TreeNode(2336);
        root.right.right = new TreeNode(2776);
        root.right.left = new TreeNode(1277);
        root.right.left.left = new TreeNode(519);
        findTarget(root, 1038);
    }
    
    public static boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        helper(root, k);
        return res;
    }
    
    private static void helper(TreeNode root, int k) {
        if (root == null) return;
        if (set.contains(root.val)) {
            System.out.println(root.val);
            res = true;
            return;
        }
        set.add(k - root.val);
//         if (root.val >= k) {
//             helper(root.left, k);
//         }
        helper(root.left, k);
        helper(root.right, k);
        return;
    }
}