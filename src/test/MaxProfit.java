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
    public int maxProfitII(int[] prices) {
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

    /**
     * 买卖股票的最佳时机 III
     */
    public int maxProfitIII(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        // 0 不买入
        // 1 第一次买入
        // 2 第一次卖出
        // 3 第二次买入
        // 4 第二次卖出
        int[][] dp = new int[prices.length][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = 0;
            if (i == 1) {
                //第二天初始化 第一次卖出
                dp[i][2] = dp[i - 1][1] + prices[i];
            } else if (i == 2) {
                //第三天初始化 第二次买入
                dp[i][3] = dp[i - 1][2] - prices[i];
            } else if (i == 3) {
                //第四天初始化 第二次卖出
                dp[i][4] = dp[i - 1][3] + prices[i];
            }

            if (dp[i - 1][1] > dp[i - 1][0] - prices[i]) {
                dp[i][1] = dp[i - 1][1];
            } else {
                dp[i][1] = dp[i - 1][0] - prices[i];
            }

            if (i > 1) {
                if (dp[i - 1][2] > dp[i - 1][1] + prices[i]) {
                    dp[i][2] = dp[i - 1][2];
                } else {
                    dp[i][2] = dp[i - 1][1] + prices[i];
                }
            }


            if (i > 2) {
                if (dp[i - 1][3] > dp[i - 1][2] - prices[i]) {
                    dp[i][3] = dp[i - 1][3];
                } else {
                    dp[i][3] = dp[i - 1][2] - prices[i];
                }
            }

            if (i > 3) {
                if (dp[i - 1][4] > dp[i - 1][3] + prices[i]) {
                    dp[i][4] = dp[i - 1][4];
                } else {
                    dp[i][4] = dp[i - 1][3] + prices[i];
                }
            }
        }

        //观察最后一天的5种结果
        int result = Integer.MIN_VALUE;
        for (int i = 0; i <= 4; i++) {
            result = Math.max(result, dp[prices.length - 1][i]);
        }
        return result;
    }

    /**
     * 买卖股票的最佳时机 III
     */
    public int maxProfit(int[] prices) {
        //不买入利润
        int result = 0;
        //第一次买入
        int buy1 = -prices[0];
        //第一次卖出
        int sell1 = 0;
        //第二次买入
        int buy2 = -prices[0];
        //第二次卖出
        int sell2 = 0;

        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return Math.max(Math.max(result, sell1), sell2);
    }

}
