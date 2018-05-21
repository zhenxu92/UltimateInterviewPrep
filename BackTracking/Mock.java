import java.util.*;
public class Mock {
    public static void main(String args[]){
        int[] nums = new int[]{1, 2, 3, 6, 7};
        System.out.println(countPairs(nums, 10));
    }
    public static int countPairs(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
          j = i + 1;
          while (j < nums.length) {
            if (nums[i] + nums[j] 
          }
        }
        return count;
    }

//     private static int binary(int diff, int[] nums) {
// 	    int lo = 0;
// 	    int hi = nums.length - 1;
// 	    while (lo < hi) {
// 		    int mid = lo + (hi - lo) / 2;
//     		if (nums[mid] < diff) {
//     			lo = mid + 1;
//     		} else {
//     			hi = mid - 1;
//     		}
// 	    }
// 	    return (lo == 0) ? 0 : lo - 1;
//     }
}

