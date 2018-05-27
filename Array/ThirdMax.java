public class ThirdMax {
    public static void main(String args[]) {
        int[] nums = new int[]{2, 2, 3, 1};
        System.out.println(thirdMax(nums));
    }
    
    public static int thirdMax(int[] nums) {
        long fm = Long.MIN_VALUE;
        long sm = Long.MIN_VALUE;
        long tm = Long.MIN_VALUE;
        if (nums == null || nums.length == 0) return 0;
        for (int i = 0; i < nums.length; i++) {
            long t = nums[i];
            if (t == fm || t == sm || t == tm) continue;
            if (t > fm) {
                tm = sm;
                sm = fm;
                fm = t;
            } else if (t > sm) {
                tm = sm;
                sm = t;
            } else if (t > tm) {
                tm = t;
            }
        }
        if (tm == Long.MIN_VALUE) return (int)fm;
        return (int)tm;
    }
}