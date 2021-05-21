package test;

/**
 * @author LeiDongxing
 * created on 2021/5/21
 * 不相交的线
 */
public class UncrossedLines {
    //可以理解成求两个数组的最长公共子序列
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            int num1 = nums1[i - 1];
            for (int j = 1; j <= n; j++) {
                int num2 = nums2[j - 1];
                if (num1 == num2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        UncrossedLines ul = new UncrossedLines();
        System.out.println(ul.maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));//2
        System.out.println(ul.maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}));//3
        System.out.println(ul.maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1}));//2
    }
}
