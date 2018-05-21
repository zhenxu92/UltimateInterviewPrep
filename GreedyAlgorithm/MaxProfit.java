//  LeetCode# 122 Best time to buy and sell a stock
// @author:Zhen Xu
//
// There are two cases
// One, you can just buy and sell for once. In this case, you will need to
// just keep track of the minimum value when traversing the list and then keep track 
// the difference between this min value and rest of the values that are bigger than it
// e.g. 6 2 0 4 3 2 8, you will have 2 at first because 6 > 2, then you find 0 is even
// smaller, than 0 is the min, than you find anything smaller than 0, you subistute it 
// into min value, other wise, just calculate the maximum profit
//
// Two, you can buy and sell many times. In that case, you will just need to find 
// every possible chance to gain profit.
// e.g.  5 3 7 1 4  0 8 2 6
// 3 - 7, 1 - 4, 0 - 8 and 2 - 6 are all profitable chance.
// 
public class MaxProfit {
    
    static int startpos = 0;
    static int endpos = 0;
    static int max = 0;
    
    public static void main (String args[]) {
        int[] prices = {1, 3, 7, 6, 8};
        System.out.println(solution(prices));    
    }
    
    public static int solution(int[] prices) {
        if(prices.length == 0) return 0;
        while (endpos != prices.length - 1 && startpos != prices.length - 1) {
            max += helper(prices);
        }
        return max;
    }
    
    public static int helper (int[] prices) {
        int min = prices[startpos];
        int profit = 0;
        
        for (int i = startpos + 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                startpos = i;
                return profit;
            } else {
                if (prices[i] - min > profit) {
                    profit = prices[i] - min;
                    endpos = i;
                }
            }
        }
        return profit;
    }
}