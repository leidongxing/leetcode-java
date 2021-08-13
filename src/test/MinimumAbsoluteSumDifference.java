package test;

import java.util.Arrays;

/**
 * @author LeiDongxing
 * created on 2021/7/14
 * 绝对差值和
 */
public class MinimumAbsoluteSumDifference {
    /**
     * @param nums1 任意一个元素可以替换至多一个元素
     * @param nums2
     * @return 返回nums1与nums2最小绝对差值和
     */
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int[] tmp = Arrays.copyOf(nums1, nums1.length);
        int n = nums1.length;
        Arrays.sort(tmp);
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums1.length; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
             

        }


        int mod = (int) 1e9 + 7;
        return (int) ((sum - max) % mod);
    }
}
