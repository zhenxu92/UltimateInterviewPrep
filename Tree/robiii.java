public class robiii {
        public static void main(String args[]) {
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.right = new TreeNode(3);
            root.right.right = new TreeNode(1);
            System.out.println(rob(root));
        }
        public static int rob(TreeNode root) {
        // Sanity Check
        if (root == null) return 0;
        
        int top = 0;
        int bot = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        // DFS init
        q.add(root);
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size != 0) {
                TreeNode temp = q.poll();
                if (count / 2 == 0) {
                    top += temp.val;
                } else {
                    bot += temp.val;
                }
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
                size--;    
            }
            count++;
        }
        return Math.max(top, bot);
    }
}