package test;

/**
 * @author LeiDongxing
 * created on 2021/3/4
 * 最长递增子序列
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //以i为结尾的最长子序列长度
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            //从i往前推
            for (int j = 0; j < i; j++) {
                //有比它小的 更新
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
