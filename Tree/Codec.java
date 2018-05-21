import java.util.*;
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // DS
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        StringBuilder sb = new StringBuilder();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                sb.append(node.val + " ");
            } else {
                sb.append("N ");
                continue;
            }
            q.offer(node.left);
            q.offer(node.right);
        }
        return sb.toString().trim();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // sanity check
        if (data ==  null || data.length() == 0) return null;
        // DS
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        String[] arr = data.split(" ");
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        q.offer(root);
        for (int i = 1; i < arr.length; i++) {
            TreeNode node = q.poll();
            if (!arr[i].equals("N")) {
                TreeNode left = new TreeNode(Integer.valueOf(arr[i]));
                node.left = left;
                q.offer(left);
            }
            
            if (!arr[++i].equals("N")) {
                TreeNode right = new TreeNode(Integer.valueOf(arr[i]));
                node.right = right;
                q.offer(right);
            }
        }
        return root;
    }
    
    // visualize a tree
    public void visualize(TreeNode root) {
        // Using BFS
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int size = 1;
        while (!q.isEmpty()) {
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                // print element
                
                System.out.printf("%10s", node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                
                if (node.right != null) {
                    q.offer(node.right);
                }          
            }
            size = q.size();
            // print dashes
            System.out.println();  
        }
    }

}