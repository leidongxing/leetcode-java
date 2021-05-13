package test;

/**
 * @author LeiDongxing
 * created on 2021/5/13
 * 停在原地的方案数
 */
public class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps {
    /**
     * 在恰好执行 steps 次操作以后，指针仍然指向索引0处的方案数。
     *
     * @param steps  步数     1<= steps<=500
     * @param arrLen 总长度   1<=arrLen<=10^6
     *               返回方案数 模 10^9 + 7 后的结果
     */
    public int numWays(int steps, int arrLen) {
        //最远能返回0的地方
        //int maxLen = (arrLen / 2) + 1;
        int maxColumn = Math.min(arrLen - 1, steps);
        int[][] dp = new int[steps + 1][maxColumn + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= maxColumn; j++) {
                //当前位置 = 前面的位置后退一步  后面的位置前进一步
                dp[i][j] = dp[i - 1][j];
                if (j - 1 >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % 1000000007;
                }
                if (j + 1 <= maxColumn) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % 1000000007;
                }
            }
        }
        return dp[steps][0];
    }
}
