import java.util.*;
public class TreeAmp {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String args[]) {
        Codec c = new Codec();
        TreeNode root = c.deserialize("1 2 3 4 5 6 7 8 9 N N N N N N");
        System.out.println(TreeAmplitude(root));
    }
    
    public static int TreeAmplitude(TreeNode root) {
        helper(root);
        return max - min;   
    }
    
    private static void helper(TreeNode root) {
        if (root == null) return;
        if (root.val > max) max = root.val;
        if (root.val < min) min = root.val;
        helper(root.left);
        helper(root.right);
    } 
    
    public static int TreeAmplitude2(TreeNode root) {
        return helper2(root, root.val, root.val);
    }
    
    private static int helper2(TreeNode root, int min, int max) {
        if (root == null) return max - min;
        
        if (root.val < min) min = root.val;
        if (root.val > max) max = root.val;
        
        return Math.max(helper2(root.left, min, max), helper2(root.right, min, max));
    }
}