// #518 CoinChangeII
public class CoinChangeII {
    public static void main(String args[]) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 5;
        System.out.println(coinChange(coins, amount));
    }
    
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i < amount + 1; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}