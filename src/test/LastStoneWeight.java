package test;

import java.util.Arrays;

/**
 * @author LeiDongxing
 * created on 2021/6/8
 * 最后一块石头的重量
 */
public class LastStoneWeight {

    /**
     * @param stones stones[i]表示第i块石头的重量
     * @return 返回此石头 最小的可能重量
     */
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        //能凑出来的最大总和
        int t = sum / 2;
        //dp[i][j]前i个石头能否凑出重量不超过j的最大重量
        int[][] dp = new int[n + 1][t + 1];
        for (int i = 1; i <= n; i++) {
            int last = stones[i - 1];
            for (int j = 0; j <= t; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= last) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - last] + last);
                }
            }
        }
        return Math.abs(sum - dp[n][t] - dp[n][t]);
    }
}
