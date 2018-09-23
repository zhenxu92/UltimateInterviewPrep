public class MovieRating {
    public static void main(String args[]) {
        int[] ratings = new int[]{9, -1, -3, 4, 5};
        System.out.println(maximizeRatings(ratings));
    }
    
    public static int maximizeRatings(int[] ratings) {
        int[][] dp = new int[ratings.length][2];
        dp[0][0] = 0;
        dp[0][1] = ratings[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = Math.max(dp[i - 1][0] + ratings[i], dp[i - 1][1] + ratings[i]);
        }
        return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
    }
}