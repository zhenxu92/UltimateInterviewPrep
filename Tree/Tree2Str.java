import java.util.*;
public class Tree2Str {
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String args[]) {
        Codec c = new Codec();
        TreeNode t = c.deserialize("1 2 3 N 4 N N N N");
        System.out.println(tree2str(t));
    }
    
    public static String tree2str(TreeNode t) {
        helper(t);
        return sb.toString();
    }
    
    private static void helper(TreeNode t) {
        if (t == null) return;
        if (t != null) sb.append(t.val);
        if (t.left == null && t.right == null) return;
        sb.append('(');
        helper(t.left);
        sb.append(')');
        if (t.right != null) {
            sb.append('(');
            helper(t.right);
            sb.append(')');
        
        }
    }
}