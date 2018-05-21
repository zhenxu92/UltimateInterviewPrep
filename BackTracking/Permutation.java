import java.util.*;
public class Permutation{
    public static List<List<Integer>> res = new ArrayList<List<Integer>>();
    
    public static void main(String args[]) {
        int[] nums = new int[] {1, 2, 3};
        permutate(nums);    
    }
    
    public static List<List<Integer>> permutate(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        backTracking(res, nums, new ArrayList<Integer>(), 0);
        return res;
    }
    
    private static void backTracking(List<List<Integer>> res, int[] nums, List<Integer> tempList, int start) {
        if (start == nums.length) {
            res.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backTracking(res, nums, tempList, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}