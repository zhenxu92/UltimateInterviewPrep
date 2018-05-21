public class IsSubTree {
    public static void main(String args[]) {
        Codec c = new Codec();
        TreeNode s = c.deserialize("3 4 5 1 2 N N");
        TreeNode t = c.deserialize("4 1 2");
        System.out.println(isSubTree(s, t));
    }
    
    public static boolean isSubTree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubTree(s.left, t) || isSubTree(s.right, t);
    }
    
    private static boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        
        if (s.val != t.val) return false;
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
    
}   