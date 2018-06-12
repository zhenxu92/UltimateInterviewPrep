public class CountUnivalueSubtree {
    public static int res = 0;
    public static void main(String args[]) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(5);
        System.out.println(countUnivalSubtrees(root));
        System.out.println(countUnivalSubtrees2(root));
    }

    // O(n)
    public static int countUnivalSubtrees(TreeNode root) {
        helper(root);
        return res;
    }
    
    public static boolean helper(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) {
            res++;
            return true;
        }
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        if (left && right) {
            if (root.left == null && root.right != null && root.val == root.right.val) {
                res++;
                return true;
            }
            if (root.right == null && root.left != null && root.val == root.left.val) {
                res++;
                return true;
            }
            if (root.left != null && root.right != null && root.val == root.left.val && root.val == root.right.val) {
                res++;
                return true;
            }
        }
        return false;
    }
    
    // O(n^2) top-down
    public static int countUnivalSubtrees2(TreeNode root) {
        if (root == null) return 0;
        if (isUni(root)) {
            return countUnivalSubtrees2(root.left) + countUnivalSubtrees2(root.right) + 1;
        } else {
            return countUnivalSubtrees2(root.left) + countUnivalSubtrees2(root.right);
        }
    }
    
    private static boolean isUni(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null && root.right != null && root.val == root.right.val) {
            return isUni(root.right);
        }
        if (root.right == null && root.left != null && root.val == root.left.val) {
            return isUni(root.left);
        }
        if (root.val == root.right.val && root.val == root.left.val) {
            return isUni(root.left) && isUni(root.right);
        }
        return false;
    }
}