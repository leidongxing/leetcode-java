package test;

/**
 * @author LeiDongxing
 * created on 2021/6/11
 * 完全平方数
 */
public class PerfectSquares {
    /**
     * @param n 返回和为n的完全平方数的最少数量
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            //最大就是 由1拼成
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
