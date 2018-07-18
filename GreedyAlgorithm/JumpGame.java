public class JumpGame {
    public static void main(String args[]) {
        int[] nums = new int[]{1,3,1,1,4,2,0,2,0,0};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        boolean[] canJump = new boolean[nums.length];
        canJump[canJump.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            int tp = nums[i];
            if (canJump[Math.min(i + tp, nums.length - 1)]) {
                int j = i;
                while (!canJump[j]) {
                    canJump[j] = true;
                    j++;
                }
            }   
        }
        return canJump[0];
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