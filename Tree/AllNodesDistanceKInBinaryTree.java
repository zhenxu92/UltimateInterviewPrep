import java.util.*;
public class AllNodesDistanceKInBinaryTree {
    public static Map<TreeNode, TreeNode> parents;
    public static TreeNode tar;
    public static void main(String args[]) {
        Codec c = new Codec();
        TreeNode root = c.deserialize("0 2 1 N N 3 N");
        TreeNode target = new TreeNode(3);
        System.out.println(distanceK(root, target, 3).toString());
    }
    
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        parents = new HashMap<TreeNode, TreeNode>();
        dfs(root, target);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(tar);
        int dist = 0;
        Set<TreeNode> visited = new HashSet<>();
        while (!q.isEmpty()) {
            if (dist == K) break;
            int size = q.size();
            dist++;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.remove();
                if (visited.contains(cur)) continue;
                visited.add(cur);
                System.out.println(cur.val);
                if (cur.left != null && cur.left.val != target.val && !visited.contains(cur.left)) {
                    q.add(cur.left);
                }
                
                if (cur.right != null && cur.right.val != target.val && !visited.contains(cur.right)) {
                    q.add(cur.right);
                }
                
                if (parents.containsKey(cur) && !visited.contains(parents.get(cur))) {
                    q.add(parents.get(cur));
                }
            }

        }
        
        while (!q.isEmpty()) {
            res.add(q.remove().val);
        }
        return res;    
    }
    
    public static void dfs(TreeNode root, TreeNode target) {
        if (root.val == target.val) {
            tar = root;
            return;
        }
        if (root.left != null) {
            parents.put(root.left, root);
            dfs(root.left, target);
        }
            
        if (root.right != null) {
            parents.put(root.right, root);
            dfs(root.right, target);
        }
    }
}