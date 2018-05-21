public class RemoveKDuplicates {
    public static void main(String args[]) {
        int[] nums = new int[] {1, 1, 1,1,1,1,1,2,2,2,2,2,23,3,3,3,3};
        removeDuplicates(nums);
    }
    
    public static void removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n;
            }
        }
    }
}