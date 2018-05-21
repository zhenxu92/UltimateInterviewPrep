import java.util.*;
public class Subsets {
    public static List<List<Integer>> res = new ArrayList<List<Integer>>();
    public static void main(String args[]) {
        int[] nums = new int[] {1, 2, 3};
        subsets(nums);
    }
    
    public static List<List<Integer>> subsets(int[] nums) {
        backTracking(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }
    
    public static void backTracking(List<List<Integer>> res, List<Integer> tempList, int[] nums, int start) {
        res.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backTracking(res, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}