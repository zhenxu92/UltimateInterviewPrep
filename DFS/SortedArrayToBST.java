public class SortedArrayToBST {
    public static void main (String args[]) {
        int[] nums = {1, 2, 3};
        helper(nums, 0, nums.length - 1);
    }
    
    public static TreeNode helper(int[] nums, int left, int right) {
        int mid = (left + right) / 2;
        
        if (left <= right) {
            TreeNode node = new TreeNode(nums[mid]);
            node.left = helper(nums, left, mid - 1);
            node.right = helper(nums, mid + 1, right);
        }
        return node;
    }
}