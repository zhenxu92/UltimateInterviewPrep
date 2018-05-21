public class RemoveDuplicateI {
    public static void main(String args[]) {
        int[] nums = new int[] {1, 1, 1, 2, 2, 3};
        removeDuplicates2(nums);
    }
    
    public static int removeDuplicates(int[] nums) {
        // sc 
        if (nums == null || nums.length == 0) return 0;
        int mark = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[mark + 1] = nums[i + 1];
                mark++;
            }
        }
        
        nums[mark + 1] = nums[nums.length - 1];
        for (int i = mark + 1; i < nums.length; i++) {
            nums[i] = 0;
        }
        
        return mark;
    }
    
    public static int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }
}