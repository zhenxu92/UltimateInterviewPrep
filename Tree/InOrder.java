
import java.util.*;
public class InOrder {
    public static void main(String args[]) {
        Codec c = new Codec();
        TreeNode root = c.deserialize("1 N 2 3 N N N");
        inorderTraversal(root);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !s.empty()) {
            while (cur != null) {
                s.add(cur);
                cur = cur.left;
            }            
            cur = s.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}