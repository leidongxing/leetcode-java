package test;

/**
 * @author LeiDongxing
 * created on 2021/6/6
 * 一和零
 */
public class OnesAndZeroes {
    /**
     * @param strs 二进制字符串数组
     * @param m    最多m个0
     * @param n    最多n个1
     * @return 最大子集大小
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int[] count = count(s);
            for (int zeroes = m; zeroes >= count[0]; zeroes--) {
                for (int ones = n; ones >= count[1]; ones--) {
                    dp[zeroes][ones] = Math.max(dp[zeroes - count[0]][ones - count[1]] + 1, dp[zeroes][ones]);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 获取每一个字符串的 0 1 个数
     */
    private int[] count(String s) {
        int[] c = new int[2];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - '0']++;
        }
        return c;
    }
}
