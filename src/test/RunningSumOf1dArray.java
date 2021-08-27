package test;

/**
 * @author LeiDongxing
 * created on 2021/8/28
 * 一维数组的动态和
 */
public class RunningSumOf1dArray {
    /**
     * 「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
     */
    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] + nums[i];
        }
        return result;
    }
}
