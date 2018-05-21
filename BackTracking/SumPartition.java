import java.util.*;
public class SumPartition {

    public static void main(String args[]) {
        int[] nums = new int[]{1, 5, 5, 11};
        System.out.println(canPartition(nums));
    }
    public static boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        Arrays.sort(nums);
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) return false;
        boolean[] used = new boolean[nums.length];
        return backTracking(nums, sum / 2, used);
    }
    
    private static boolean backTracking(int[] nums, int target, boolean[] used) {
        if (target < 0) {
            return false;
        } else if (target == 0) {
            return true;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue;
                used[i] = true;
                return backTracking(nums, target - nums[i], used) || backTracking(nums, target, used);
            }
        }
        return false;
    }
}