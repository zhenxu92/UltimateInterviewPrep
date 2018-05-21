public class CountUnival {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        System.out.println(countUnivalSubtrees(root));
    }
    
    public static int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        if (isUni(root)) {
            return 1 + countUnivalSubtrees(root.left) + countUnivalSubtrees(root.right);
        } else {
            return countUnivalSubtrees(root.left) + countUnivalSubtrees(root.right);
        }
    }
    
    public static boolean isUni(TreeNode root) {
        if (root.left != null && root.right != null) {
            if (root.left.val != root.val || root.right.val != root.val) {
                return false;
            } else {
                return isUni(root.left) && isUni(root.right);
            }
        } else if (root.left != null) {
            if (root.left.val == root.val) {
                isUni(root.left);
            } else {
                return false;
            }
        } else if (root.right != null) {
            if (root.right.val == root.val) {
                isUni(root.right);
            } else {
                return false;
            }
        }
        return true;
    }
}