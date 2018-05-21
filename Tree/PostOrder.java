import java.util.*;
public class PostOrder {
    public static void main(String args[]) {
        Codec c = new Codec();
        TreeNode root = c.deserialize("1 N 2 3 N N N");
        postorderTraversal(root);
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while(cur != null) {
                if (cur.left == null && cur.right == null) break;
                stack.push(cur);
                cur = cur.left;
            }
            
            cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur);
                cur = cur.right;
            } else {
                res.add(cur.val);
            }
            
        }
        return res;
    }
}