package test;

/**
 * @author LeiDongxing
 * created on 2020/10/11
 * 分割等和子集
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        //dp[i][j] 从0到i中选择数 和等于j
        boolean[][] dp = new boolean[nums.length][target + 1];
        dp[0][0] = true;
        if (nums[0] == target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                //目前还小于j
                if (nums[i] <= j) {
                    //i-1个元素中能构成j  或者 i-1个元素能构成 j-nums[i] +nums[i]
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
                if (dp[i][target]) {
                    return true;
                }
            }
        }
        return dp[nums.length - 1][target];
    }
}
