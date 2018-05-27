public class DetectCircleArray {
    public static void main(String args[]) {
        int[] nums = new int[]{1,3,4,2,2};
        findDuplicate(nums);
    }
    public static int findDuplicate(int[] nums) {
        if (nums.length < 1) return -1;
        int hare = nums[0];
        int tortoise = nums[nums[0]];
        while (hare != tortoise) {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        }
        
        hare = 0;
        while (hare != tortoise) {
            hare = nums[hare];
            tortoise = nums[tortoise];
        }
        return tortoise;
    }
}