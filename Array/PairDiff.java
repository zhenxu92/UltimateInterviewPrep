import java.util.*;
public class PairDiff {
    public static List<int[]> res = new ArrayList<>();
    public static void main(String args[]) {
        int[] nums = new int[]{0, -1, -2, 2, 1};
        int target = 1;
        pair2(nums, target);
        for (int[] arr : res) {
            System.out.println(arr.toString());
        }
    }  
    
    private static void pair1(int[] nums, int target) {
        if (nums.length < 2) return;
        Map<Integer, Integer> map = new HashMap<>();
        // x - y = target
        // y = x - target
        for (int n : nums) {
            map.put(n - target, n);
        }
        
        for (int n : nums) {
            if (map.containsKey(n)) {
                int[] ans = new int[]{map.get(n), n};
                res.add(ans);    
            }
        }
    }
    
    private static void pair2(int[] nums, int target) {
        if (nums.length < 2) return;
        Arrays.sort(nums);
        // -2 -1 0 1 2
        // x - y = target
        int lo = 0; 
        int hi = 1;
        while (hi <= nums.length - 1) {
            if (nums[hi] - nums[lo] == target) {
                res.add(new int[]{nums[hi], nums[lo]});
                lo++;
                hi++;
            } else if (nums[hi] - nums[lo] > target) {
                lo++;
            } else {
                hi++;
            }
        }
    } 
}