public class BurstBalloon {
    public static void main(String args[]) {
        int[] balloons = {4, 3, 1, 5, 8};
        System.out.println(maxCoins(balloons));
    }
    
    public static int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int j = 1; j <= n; j++) {
            for (int i = j - 1; i >= 0; i--) {
                int max = 0;
                for (int k = i; k <= j - 1; k++) {
                    int left = dp[i][k];
                    int right = dp[k + 1][j];
                    int numMid = nums[k];
                    int numLeft = (i == 0 ? 1 : nums[i - 1]);
                    int numRight = (j == n ? 1 : nums[j]);
                    max = Math.max(left + right + numMid * numLeft * numRight, max);
                }
                dp[i][j] = max;
            }
        }
        return dp[0][n];
    }
}