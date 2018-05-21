import java.util.*;
public class BinaryTreeRightSideView {
    public TreeNode root;
    
    public BinaryTreeRightSideView (TreeNode root) {
        this.root = root;
    }
    
//     public List<Integer> rightSideView (TreeNode root) {
//         List<Integer> list = new ArrayList<Integer>();
//         Queue<TreeNode> q = new LinkedList<TreeNode>();
//         
//         if (root == null)  return list;
//         
//         q.offer(root);
//         while(q.size() != 0) {
//             int size = q.size();
//             for (int i = 0; i < size; i++) {
//                 TreeNode cur = q.poll();
//                 if (i == 0) {
//                     list.add(cur.val);
//                 }
//                 
//                 if (cur.left != null) q.offer(cur.right);
//                 if (cur.right != null) q.offer(cur.left);
//             }
//         }
//         
//         return list;
//     }
    
    public List<Integer> rightSideView (TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        rightSideView(root, list, 0);
        return list;    
    }
    
    private void rightSideView (TreeNode root, List<Integer> list, int curDepth) {
        if (root == null) return;
        
        if (curDepth == list.size()) {
            list.add(root.val);
        }
        
        if (root.left != null) rightSideView(root.right, list, curDepth + 1);
        if (root.right != null) rightSideView(root.left, list, curDepth + 1);
    }
    
    public static void main (String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        BinaryTreeRightSideView p = new BinaryTreeRightSideView(root);
        List<Integer> myList = p.rightSideView(p.root);
        System.out.println(myList.toString());
    }
}