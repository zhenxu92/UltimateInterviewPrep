public class RootToLeafSum {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        sumToLeaf(root);
    }
    
    public static int sumToLeaf(TreeNode root) {
        if (root == null) return 0;
        System.out.println(helper(root, 0));
        return helper(root, 0);
    }
    
    public static int helper(TreeNode root, int val) {
        //System.out.println(val);
        if (root == null) return val;
        int sum = val * 10 + root.val;

        return helper(root.left, sum) + helper(root.right, sum);
    }
}