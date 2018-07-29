import java.util.*;
public class MinimumTopToBottom {
    public static void main(String args[]) {
        int[][] paths = new int[][]{
            {2,3,1},
            {4,6,5},
            {6,8,9}
        };
        
        System.out.println(getMinimumPath(paths));
    }
    
    public static int getMinimumPath(int[][] paths) {
        int[][] dp = paths;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                // i, j
                Integer left = null;
                Integer right = null;
                Integer mid = null;
                if (j > 0) {
                    left = dp[i - 1][j - 1];
                }
                if (j < dp[0].length - 1) right = dp[i - 1][j + 1];
                mid = dp[i - 1][j];
                int min = mid;
                if (left != null) {
                    min = Math.min(min, left);
                }
                if (right != null) {
                    min = Math.min(min, right);
                }
                dp[i][j] += min;
            }
        }
        int res = dp[dp.length - 1][0];
        for (int i = 1; i < dp[0].length; i++) {
            res = Math.min(res, dp[dp.length - 1][i]);        
        }
        return res;
    }
}