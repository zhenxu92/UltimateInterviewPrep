// NextGreaterElement V1.0
// @author Zhen XU
// This is not correct yet
public class NextGreaterElement {
    public static void main (String args[]) {
        int[] findNums = {4, 1, 2};
        int[] nums = {1, 3, 4, 2};
        int[] ans = Solution(findNums, nums);
        
    }
    
    public static int[] Solution (int[] findNums, int[] nums) {
        int[] ans = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (findNums[i] >= nums[j]) {
                    ans[i] = -1;
                } else {
                    ans[i] = nums[j];
                    break;
                }
            }
        }
        return ans;        
    }
}