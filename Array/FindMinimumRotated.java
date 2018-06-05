public class FindMinimumRotated {
    public static void main(String args[]) {
        int[] nums = new int[]{2, 1};
        System.out.println(findMin(nums));    
    }
    
   public static int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        int start = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid < nums.length - 1 && nums[mid] >= nums[0] && nums[mid + 1] < nums[0]) {
                start = mid + 1;
                break;
            }
            if (mid > 0 && nums[mid] <= nums[0] && nums[mid - 1] > nums[0]) {
                start = mid;
                break;
            }
            
            if (nums[mid] > nums[0]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }  
        return nums[start];
    }
}