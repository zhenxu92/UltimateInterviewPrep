public class TreeSum {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new  TreeNode(1);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        System.out.println(sumTree(root));
        printTree(root);
    }
    
    public static int sumTree(TreeNode root) {
        if (root == null) return 0;
        return root.val + sumTree(root.left) + sumTree(root.right);
    }
    
    public static int printTree(TreeNode root) {
        if (root == null) return 0;
        System.out.println(root.val + printTree(root.left) + printTree(root.right));
        return root.val;
    }
}