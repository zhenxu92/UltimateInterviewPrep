import java.util.*;
public class CountTriangles {
    public static int res = 0;
    public static void main(String args[]) {
        int[] nums = new int[]{2,2,3,4};
        System.out.println(triangleNumber(nums));
    }
    public static int triangleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backTracking(nums, new ArrayList<Integer>(), used);
        res = res / 2;
        return res;
    }
    
    private static void backTracking(int[] nums, List<Integer> tempList, boolean[] used) {
        if (tempList.size() == 3) {
            if (isTriangle(tempList)) {
                res++;
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                tempList.add(nums[i]);
                used[i] = true;
                backTracking(nums, tempList, used);
                tempList.remove(tempList.size() - 1);
                used[i] = false;
            }
        }
    }
    
    private static boolean isTriangle(List<Integer> tempList) {
        Collections.sort(tempList);
        if (tempList.get(0) + tempList.get(1) > tempList.get(2)) return true;
        else return false;
    }
}