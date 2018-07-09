public class MaxSubArrayLen {
    public static void main(String args[]) {
        int[] nums = new int[]{1, -1, 5, -2, 3};
        int k = 3;
        
        System.out.println(maxSubArrayLen(nums, 3));
    }   
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        
        int res = Integer.MIN_VALUE;
        
    }
}