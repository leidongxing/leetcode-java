package test;

/**
 * @author LeiDongxing
 * created on 2021/1/28
 * 连续数列
 */
public class ContiguousSequenceLCCI {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        if (nums.length == 0) {
            return result;
        }
        //以i为结尾最大值
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
