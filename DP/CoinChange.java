// #322
import java.util.*;
public class CoinChange {
    public static void main(String args[]) {
        int[] coins = new int[]{1,2,5};
        int amount = 100;
        System.out.println(coinChange(coins, amount));
    }
    
    
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        //Arrays.sort(coins);
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int coin : coins) {
            for (int i = coin; i < amount + 1; i++) {
                int div = Integer.MAX_VALUE;
                int tp = (dp[i - coin] == Integer.MAX_VALUE) ? dp[i - coin] : dp[i - coin] + 1;
                if (i % coin == 0) div = i / coin;
                dp[i] = Math.min(div, Math.min(tp, dp[i]));
            }
        }
        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
    }
}