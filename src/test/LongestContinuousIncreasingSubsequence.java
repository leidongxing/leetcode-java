package test;

/**
 * @author LeiDongxing
 * created on 2021/1/24
 * 最长连续递增序列
 */
public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int result = 1;
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                result = Math.max(result, i - start);
                start = i;
            }
        }
        return Math.max(result, nums.length - start);
    }

    public static void main(String[] args) {
        LongestContinuousIncreasingSubsequence l = new LongestContinuousIncreasingSubsequence();
        System.out.println(l.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));//3
        System.out.println(l.findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));//1
        System.out.println(l.findLengthOfLCIS(new int[]{1, 3, 5, 6, 7}));//5
        System.out.println(l.findLengthOfLCIS(new int[]{1, 3, 2, 6, 7}));//3
    }
}
