package test;

/**
 * @author LeiDongxing
 * created on 2020/11/8
 * 买卖股票的最佳时机
 */
public class MaxProfit {
    /**
     * 买卖股票的最佳时机 II
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        //持有股票利润
        int dp0 = -prices[0];
        //卖出股票利润
        int dp1 = 0;
        for (int i = 1; i < prices.length; i++) {
            int newDp0 = Math.max(dp0, dp1 - prices[i]);
            int newDp1 = Math.max(dp1, dp0 + prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp1;
    }
}
