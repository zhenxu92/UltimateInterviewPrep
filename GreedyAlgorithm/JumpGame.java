public class JumpGame {
    public static void main(String args[]) {
        int[] nums = new int[]{2,0};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        return backTracking(nums, 0);
    }
    
    public static boolean backTracking(int[] nums, int start) {
        if (start == nums.length - 1) {
            return true;
        }
        if (start > nums.length - 1) return false;
        int tp = nums[start];

        if (tp == 0) return false;
        for (int i = tp; i > 0; i--) {

            if (backTracking(nums, start + i)) {
                return true;
            }
        }
        return false;
    }
}